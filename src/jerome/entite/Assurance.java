package jerome.entite;

/**
 * The type Assurance.
 */
public class Assurance {
    /**
     * The constant BLEU.
     */
    public static final int BLEU = 4;
    /**
     * The constant VERT.
     */
    public static final int VERT = 3;
    /**
     * The constant ORANGE.
     */
    public static final int ORANGE = 2;
    /**
     * The constant ROUGE.
     */
    public static final int ROUGE = 1;
    /**
     * The constant REFUSEE.
     */
    public static final int REFUSEE = 0;
    /**
     * The constant Avantage.
     */
    public static final int Avantage = 1;
    private int valeurAssu;
    private int anciennete;

    /**
     * Instantiates a new Assurance.
     *
     * @param ageV         the age v
     * @param dureePermisV the duree permis v
     * @param nbAccidentV  the nb accident v
     */
    public Assurance(final int ageV, final int dureePermisV, final int nbAccidentV) {
        int valeur = calculAssu(ageV, dureePermisV, nbAccidentV);
        setValeurAssu(valeur);
        setAnciennete(0);
    }

    /**
     * Gets anciennete.
     *
     * @return the anciennete
     */
    public int getAnciennete() {
        return anciennete;
    }

    /**
     * Sets anciennete.
     *
     * @param anciennete the anciennete
     */
    public void setAnciennete(int anciennete) {
        this.anciennete = anciennete;
    }

    /**
     * Gets valeur assu.
     *
     * @return the valeur assu
     */
    public int getValeurAssu() {
        return valeurAssu;
    }

    /**
     * Sets valeur assu.
     *
     * @param valeurAssu the valeur assu
     */
    public void setValeurAssu(int valeurAssu) {
        this.valeurAssu = valeurAssu;
    }

    /**
     * Calcul assu int.
     *
     * @param age         the age
     * @param dureePermis the duree permis
     * @param nbAccident  the nb accident
     * @return the int
     */
    public int calculAssu(final int age, final int dureePermis, final int nbAccident) {
        int valeur = VERT - nbAccident;
        if (age < 25) {
            valeur -= 1;
        }
        if (dureePermis < 2) {
            valeur -= 1;
        }
        if (getAnciennete() >= 5) {
            valeur += Avantage;
        }
        if (valeur < 0) {
            valeur = REFUSEE;
        }
        return valeur;
    }

    @Override
    public String toString() {
        String txt = "tarif assurance : ";
        switch (valeurAssu) {
            case BLEU:
                txt += "Bleu \n";
                break;
            case VERT:
                txt += "Vert \n";
                break;
            case ORANGE:
                txt += "Orange \n";
                break;
            case ROUGE:
                txt += "Rouge \n";
                break;
            default: {
                txt += "non assuré\n";
                return txt;
            }
        }
        txt += String.format("ancienneté : %d \n", anciennete);
        return txt;
    }
}
