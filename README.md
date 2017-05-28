# Challenger #

Aplikacja społecznościowa służąca do tworzenia wyzwań.
Zarejestrowany użytkownik może tworzyć różnego typu wyzwania dla znajomych, np. przebiegnięcie maratonu, przejście poziomu w grze, nauczenie się gry na instrumencie, czy też wypicie piwa ze znajomymi. 
Wyzwana osoba dostaje powiadomienie i może zaakceptować bądź tez odrzucić wyzwanie. 

Każde z wyzwań ma swoją wagę punktową podbijaną przez osoby nie biorące udziału w wyzwaniu. Jeśli komuś się podoba, może podbić punkty o 10. 
Każdy użytkownik walczy o jak największą ilość punktów, aby być w czołówce rankingu. 

W kolejnych wersjach będzie możliwe tworzenie grupy znajomych, tak aby rywalizować tylko między sobą, a nie z wszystkimi użytkownikami.


### Drzewo katalogów ###
* /java
   + /com.aghpk.challenger
     - /api
     - /config
     - /controllers
     - /data
     - /elasticLoaders
     - /exception
     - /model
     - /respository
     - /respositoryElastic
     - /service
     - /tools
   + /resources
     - /sass
     - /static
        + /app
        + /node_modules

### Wzorzec projektowy ###
Zastosowaliśmy wzorzec projektowy XXXXX świetnie nadał on się do obsługi punktów. 
W naszej aplikacji mamy kilka rodzajów. Stworzyliśmy klasę PointFactory, która do metody createPoint jako string otrzymuje typ punktów i zwraca nowy obiekt konkretnego typu.


```
#!java

public class PointFactory {

    public interface PointType {
        String BASIC = "BASIC";
        String STAR = "STAR";
        String MAIN = "MAIN";
    }

    public static Point createPoint(String pointType) {
        switch (pointType) {
            case PointType.BASIC:
                return new BasicPoint();
            case PointType.MAIN:
                return new MainPoint();
            case PointType.STAR:
                return new StarPoint();
        }
        throw new ApplicationException(ErrorType.WRONG_POINT_TYPE, pointType);
    }
}
```
Stworzyliśmy abstrakcyjną klasę Point, rozszerzającą inne typy punktów.


```
#!java

@Getter
@Setter
@Entity
@Table(name = "POINT")
@DiscriminatorColumn(name = "PointType")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POINT_ID")
    private Long id;

    @Column(name = "QUANTITY")
    private Long quantity;

    @Column(name = "PointType", insertable = false, updatable = false)
    private String type;

    @Column(name = "USER_ID", insertable = false, updatable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    @JsonManagedReference("user-point")
    private User user;

    @Column(name = "CHALLENGE_ID", insertable = false, updatable = false)
    private Long challengeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CHALLENGE_ID")
    @JsonManagedReference(value = "challenge-point")
    private Challenge challenge;
  }
}
```

Przykładowy typ punktów:

```
#!java
@Entity
@DiscriminatorValue("STAR")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class StarPoint extends Point {

    public StarPoint() {
        setType(PointFactory.PointType.STAR);
    }

}

```