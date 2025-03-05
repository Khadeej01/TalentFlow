package Candidature.DAO;

import java.util.ArrayList;
import java.util.List;

public class CandidatureDAO {
    private List<Candidature> candidatures = new ArrayList<>();
    private int nextId = 1;

    // ✅ Postuler (Apply for a job)
    public Candidature postuler(int candidatId, int offreId) {
        Candidature newCandidature = new Candidature(nextId++, candidatId, offreId, "En attente");
        candidatures.add(newCandidature);
        return newCandidature;
    }

    // ✅ Modifier une candidature
    public boolean modifierCandidature(int candidatureId, int newOffreId) {
        for (Candidature c : candidatures) {
            if (c.getId() == candidatureId) {
                c.setOffreId(newOffreId);
                return true;
            }
        }
        return false;
    }

    // ✅ Retirer une candidature
    public boolean retirerCandidature(int candidatureId) {
        return candidatures.removeIf(c -> c.getId() == candidatureId);
    }

    // ✅ Get all candidatures
    public List<Candidature> getAllCandidatures() {
        return candidatures;
    }
}
