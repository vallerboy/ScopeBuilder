package pl.oskarpolak.springsec.models;

public class Player {
    private String name;
    private int lvl;
    private int attack;
    private int defence;
    private String nickname;

    private Player(Builder builder) {
        name = builder.name;
        lvl = builder.lvl;
        attack = builder.attack;
        defence = builder.defence;
        nickname = builder.nickname;
    }

    static class Builder {
        private String name;
        private int lvl;
        private int attack;
        private int defence;
        private String nickname;

        public Builder(String name){
            this.name = name;
        }

        public Builder setLvl(int lvl) {
            this.lvl = lvl;
            return this;
        }

        public Builder setAttack(int attack) {
            this.attack = attack;
            return this;
        }

        public Builder setDefence(int defence) {
            this.defence = defence;
            return this;
        }

        public Builder setNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Player build(){
            return new Player(this);
        }
    }

}
