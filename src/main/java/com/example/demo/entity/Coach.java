    package com.example.demo.entity;

    import java.util.List;

    import jakarta.persistence.CascadeType;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.OneToMany;
    import jakarta.persistence.Table;

    @Entity
    @Table(name = "coaches")
    public class Coach {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String specialization;
        private int experienceYears;

        @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Athlete> athletes;

        public Coach() {}

        public Coach(String name, String specialization, int experienceYears) {
            this.name = name;
            this.specialization = specialization;
            this.experienceYears = experienceYears;
        }

        // Getters and Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getSpecialization() { return specialization; }
        public void setSpecialization(String specialization) { this.specialization = specialization; }

        public int getExperienceYears() { return experienceYears; }
        public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }

        public List<Athlete> getAthletes() { return athletes; }
        public void setAthletes(List<Athlete> athletes) { this.athletes = athletes; }
    }
