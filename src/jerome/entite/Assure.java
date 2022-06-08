package jerome.entite;

/**
 * The type Assure.
 */
public class Assure {
    private String nomPrenom;
    private int age;
    private int dureePermis;
    private int nbAccident;
    private Assurance assurance;

    /**
     * Instantiates a new Assure.
     *
     * @param nomPrenomV   the nom prenom v
     * @param ageV         the age v
     * @param dureePermisV the duree permis v
     * @param nbAccidentV  the nb accident v
     */
    public Assure(final String nomPrenomV,
                  final int ageV,
                  final int dureePermisV,
                  final int nbAccidentV) {
        nomPrenom = nomPrenomV;
        age = ageV;
        dureePermis = dureePermisV;
        nbAccident = nbAccidentV;
        setAssurance(new Assurance(ageV, dureePermisV, nbAccidentV));
    }

    /**
     * Gets nom prenom.
     *
     * @return the nom prenom
     */
    public String getNomPrenom() {
        return nomPrenom;
    }

    /**
     * Gets assurance.
     *
     * @return the assurance
     */
    public Assurance getAssurance() {
        return assurance;
    }

    /**
     * Sets assurance.
     *
     * @param assuranceV the assurance
     */
    public void setAssurance(final Assurance assuranceV) {
        this.assurance = assuranceV;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param ageV the age
     */
    public void setAge(final int ageV) {
        this.age = ageV;
        int valeur = assurance.calculAssu(age, dureePermis, nbAccident);
        assurance.setValeurAssu(valeur);
    }

    /**
     * Gets duree permis.
     *
     * @return the duree permis
     */
    public int getDureePermis() {
        return dureePermis;
    }

    /**
     * Sets duree permis.
     *
     * @param dureePermisV the duree permis
     */
    public void setDureePermis(final int dureePermisV) {
        this.dureePermis = dureePermisV;
        int valeur = assurance.calculAssu(age, dureePermisV, nbAccident);
        assurance.setValeurAssu(valeur);
    }

    /**
     * Gets nb accident.
     *
     * @return the nb accident
     */
    public int getNbAccident() {
        return nbAccident;
    }

    /**
     * Sets nb accident.
     *
     * @param nbAccidentV the nb accident
     */
    public void setNbAccident(final int nbAccidentV) {
        this.nbAccident = nbAccidentV;
    }

    /**
     * Ajouter accident.
     */
    public void ajouterAccident() {
        setNbAccident(getNbAccident() + 1);
        int valeur = assurance.calculAssu(age, dureePermis, nbAccident);
        assurance.setValeurAssu(valeur);

    }

    /**
     * Ajouter 1 a l'anciennete.
     */
    public void ajouterAnciennete() {
        assurance.setAnciennete(assurance.getAnciennete() + 1);
        int valeur = assurance.calculAssu(age, dureePermis, nbAccident);
        assurance.setValeurAssu(valeur);

    }

    /**
     * Surcharge du toString.
     */
    @Override
    public String toString() {
        return String.format("nom prenom : %s %n"
                                     + "age : %d %n"
                                     + "titulaire du permis depuis : %d %n"
                                     + "nombre d'accident : %s %n",
                nomPrenom, age, dureePermis, nbAccident)
                       + assurance;
    }
}
