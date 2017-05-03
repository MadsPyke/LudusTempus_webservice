package brugerautorisation.transport.soap;

import brugerautorisation.data.Bruger;
import brugerautorisation.server.Brugerdatabase;
import javax.jws.WebService;

@WebService(endpointInterface = "brugerautorisation.transport.soap.Brugeradmin")
public class BrugeradminImpl implements Brugeradmin {
    Brugerdatabase db;

    @Override
    public Bruger hentBruger(String brugernavn, String adgangskode) {
        return db.hentBruger(brugernavn, adgangskode);
    }

    @Override
    public Bruger ændrAdgangskode(String brugernavn, String adgangskode, String nyAdgangskode) {
        Bruger b = db.hentBruger(brugernavn, adgangskode);
        b.adgangskode = nyAdgangskode;
        db.gemTilFil(false);
        return b;
    }

    @Override
    public Object getEkstraFelt(String brugernavn, String adgangskode, String feltnavn) {
        return db.hentBruger(brugernavn, adgangskode).ekstraFelter.get(feltnavn);
    }

    @Override
    public void setEkstraFelt(String brugernavn, String adgangskode, String feltnavn, Object værdi) {
        db.hentBruger(brugernavn, adgangskode).ekstraFelter.put(feltnavn, værdi);
        db.gemTilFil(false);
    }
}
