    public abstract class Pessoa {// abstract torna a classe abstrato, que nao
        // pode ser inicializada

        protected String nome;

        public Pessoa(String nome) {
            this.nome = nome;
        }

        public abstract String getNome();

        public void setNome(String nome) {
            this.nome = nome;
        }
    }


