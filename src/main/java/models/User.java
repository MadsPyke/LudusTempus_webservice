package models;

public class User {
    public User(String studieNr, String username, String skypeAccount, String discordAccount, String lolSummonerName, int lolMainRole, int lolOffRole) {
        this.studieNr = studieNr;
        Username = username;
        SkypeAccount = skypeAccount;
        DiscordAccount = discordAccount;
        LolSummonerName = lolSummonerName;
        LolMainRole = lolMainRole;
        LolOffRole = lolOffRole;
    }

    public String studieNr;
    public String Username;
    public String SkypeAccount;
    public String DiscordAccount;
    public String LolSummonerName;
    public int LolMainRole;
    public int LolOffRole;
}
