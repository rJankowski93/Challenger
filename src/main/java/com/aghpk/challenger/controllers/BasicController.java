package com.aghpk.challenger.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@Controller
public class BasicController {

    private Facebook facebook;
    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    public BasicController(Facebook facebook) {
        this.facebook = facebook;
    }

    @GetMapping
    @RequestMapping(value = "/login")
    public String login() throws MessagingException {
        return "redirect:/";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "redirect:/";
    }


    @RequestMapping(value = "/logoutUser", method = RequestMethod.GET)
    public String logoutUser(HttpServletRequest request, HttpServletResponse response) {
        connectionRepository.removeConnections("facebook");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }


    @GetMapping
    @RequestMapping(value = "/facebook")
    public String helloFacebook(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }
        model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
        PagedList<Post> feed = facebook.feedOperations().getFeed();
        model.addAttribute("feed", feed);
        return "index.html";
    }

    @PostConstruct
    private void init() {
        try {
            String[] fieldsToMap = {"id", "about", "age_range", "birthday",
                    "context", "cover", "currency", "devices", "education",
                    "email", "favorite_athletes", "favorite_teams",
                    "first_name", "gender", "hometown", "inspirational_people",
                    "installed", "install_type", "is_verified", "languages",
                    "last_name", "link", "locale", "location", "meeting_for",
                    "middle_name", "name", "name_format", "political",
                    "quotes", "payment_pricepoints", "relationship_status",
                    "religion", "security_settings", "significant_other",
                    "sports", "test_group", "timezone", "third_party_id",
                    "updated_time", "verified", "viewer_can_send_gift",
                    "website", "work"};

            Field field = Class.forName(
                    "org.springframework.social.facebook.api.UserOperations")
                    .getDeclaredField("PROFILE_FIELDS");
            field.setAccessible(true);

            Field modifiers = field.getClass().getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.set(null, fieldsToMap);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
