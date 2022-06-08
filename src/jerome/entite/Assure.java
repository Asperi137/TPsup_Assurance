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
    public Assure(final String nomPrenomV, final int ageV, final int dureePermisV, final int nbAccidentV) {
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
     * @param assurance the assurance
     */
    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
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
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
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
     * @param dureePermis the duree permis
     */
    public void setDureePermis(int dureePermis) {
        this.dureePermis = dureePermis;
        int valeur = assurance.calculAssu(age, dureePermis, nbAccident);
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
     * @param nbAccident the nb accident
     */
    public void setNbAccident(int nbAccident) {
        this.nbAccident = nbAccident;
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
     * Ajouter anciennete.
     */
    public void ajouterAnciennete() {
        assurance.setAnciennete(assurance.getAnciennete() + 1);
        int valeur = assurance.calculAssu(age, dureePermis, nbAccident);
        assurance.setValeurAssu(valeur);

    }

    @Override
    public String toString() {
        return String.format("nom prenom : %s \n"
                                     + "age : %d \n"
                                     + "titulaire du permis depuis : %d \n"
                                     + "nombre d'accident : %s \n"
                                     + assurance
                , nomPrenom, age, dureePermis, nbAccident);
    }
}
