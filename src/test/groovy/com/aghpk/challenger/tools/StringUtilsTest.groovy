package com.aghpk.challenger.tools

import spock.lang.Specification

class StringUtilsTest extends Specification {

    def "should return true if email is valid"() {
        expect:
        StringUtils.validateEmail(email) == isValid

        where:
        email                           | isValid
        "example@gmail.com"             | true
        "example122@domain.au"          | true
        "123example@domain.com"         | true
        "gdf#7e@gmail.pl"               | true
        "1vcexvcampl#7e@com.com.com.pl" | true
        "czexampl#7e@com.gdsf.com"      | true
    }

    def "should return false if email is valid"() {
        expect:
        StringUtils.validateEmail(email) == isValid

        where:
        email                               | isValid
        "example#gmail.com"                 | false
        "_!%@example122@domain.au"          | false
        "!@123example@domain.com"           | false
        "gdf#7e@@@@gmail.pl"                | false
        "1vcexvcampl#7e@com/.<>.com.com.pl" | false
        "plainText"                         | false
    }
}
