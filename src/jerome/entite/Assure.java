package jerome.entite;

import java.time.LocalDate;
import java.time.Period;

/**
 * The type Assure.
 */
public class Assure {
    private String nomPrenom;
    private LocalDate dateNaiss;
    private LocalDate datePermis;

    private int nbAccident;
    private Assurance assurance;

    public Assure(String nomPrenomV, LocalDate dateNaissV, LocalDate datePermisV, int nbAccidentV) {
        this.nomPrenom = nomPrenomV;
        this.dateNaiss = dateNaissV;
        this.datePermis = datePermisV;
        this.nbAccident = nbAccidentV;
        setAssurance(new Assurance(dateNaissV, datePermisV, nbAccidentV));
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
     * Sets assurance.
     *
     * @param assuranceV the assurance
     */
    public void setAssurance(final Assurance assuranceV) {
        this.assurance = assuranceV;
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
        int valeur = assurance.calculAssu(dateNaiss, datePermis, nbAccident);
        assurance.setValeurAssu(valeur);

    }

    /**
     * Ajouter 1 a l'anciennete.
     */
    public void ajouterAnciennete() {
        assurance.setDateEntrer(assurance.getDateEntrer().plus(Period.ofYears(-1)));
        int valeur = assurance.calculAssu(dateNaiss, datePermis, nbAccident);
        assurance.setValeurAssu(valeur);

    }

    /**
     * Surcharge du toString.
     */
    @Override
    public String toString() {
        return String.format("nom prenom : %s %n"
                                     + "né le : %s %n"
                                     + "titulaire du permis depuis : %d %n"
                                     + "nombre d'accident : %s %n",
                nomPrenom, dateNaiss, datePermis.getYear(), nbAccident)
                       + assurance;
    }
}
