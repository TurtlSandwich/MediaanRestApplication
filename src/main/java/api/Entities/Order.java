package api.Entities;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "sessions")
    private long sessions;

    @Column(name = "order_time")
    private LocalTime order_time;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "meal_order",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "meal_id")}
    )
    private Set<Meal> Meals = new HashSet<>();

    public void addMeal(Meal meal) {
        Meals.add(meal);
        meal.getOrders().add(this);
    }

    public Set<Meal> getMeals() {
        return Meals;
    }

    public long getId() {
        return id;
    }

    public long getSessionId() {
        return sessions;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSessionId(long sessionId) {
        sessions = sessionId;
    }

    public long getSessions() {
        return sessions;
    }

    public void setSessions(long sessions) {
        this.sessions = sessions;
    }

    public LocalTime getOrder_time() {
        return order_time;
    }

    public void setOrder_time(LocalTime order_time) {
        this.order_time = order_time;
    }

    public void setMeals(Set<Meal> meals) {
        Meals = meals;
    }
}
