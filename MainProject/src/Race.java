public enum Race {
    Human   (600),
    Flapper (1600),
    Bonzoid (1000),
    Ugaite  (1000),
    Buzzite (1000);
    
    private final int startingMoney;
    
    private Race(int startingMoney) {
        this.startingMoney = startingMoney;
    }
    
    public int getStartingMoney() {
        return startingMoney;
    }

}
