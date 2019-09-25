
import java.util.ArrayList;


public class Hand extends BrainStorm{

       private ArrayList<Card> Cards=new ArrayList<>();
    private HandTypes type;

     Hand(Card a, Card b, Card c, Card d, Card e){
         this(a, b, c, d, e,"");
    }
    Hand(Card a, Card b, Card c, Card d, Card e,String testLabel){
        super(testLabel);
        this.Cards.add(a);
        this.Cards.add(b);
        this.Cards.add(c);
        this.Cards.add(d);
        this.Cards.add(e);

    }
    Hand(ArrayList<Card>Cards,String testLabel){
         super(testLabel);
         this.Cards=Cards;
    }
    Hand(ArrayList<Card>Cards){
         this(Cards,"");
    }

   /* public Main(string t){
            this.type=t;
        }*/


        ArrayList<Card> getHand(){
            return this.Cards;
        }

        public String getType(){
            //return  null;
            return this.type.toString();
        }

         public  void setHand(ArrayList<Card> m){
            //this.Cards=m;
        }
        public void setType(HandTypes Ht){
            this.type=Ht;
        }
        boolean cardsIterate(int prec, int next, int diff) {
            return Cards.get(next).getValour()-Cards.get(prec).getValour()==diff;
        }
        boolean cardsIterate(int prec, int next)
        {
            return cardsIterate(prec,next,1);
        }
        public boolean isASuite(){
          if(Cards.get(0).getValour()<Cards.get(1).getValour())
            for (int i=0;i<Cards.size()-1;i++)
                {
                    if(i>0&&!cardsIterate(i,i+1))return false;
                }
          else for (int i=Cards.size()-1;i>=0;i--)
            {
                if((i<Cards.size()-1)&&!cardsIterate(i+1,i))return false;
            }
            return true;
        }
        public boolean isACouleur() {
            CardColors firstColor=Cards.get(0).getColour();
            for (int i=1;i<Cards.size();i++)if(Cards.get(i).getColour()!=firstColor)return false;
            return true;
        }
        public boolean isAQuinteFlush()
        {
            return isACouleur()&&isASuite();
        }

    /**
     * retourne le nombre de paire rencontré dans une paire
     * @return number of time pair card are seen
     */
    public int nbOccurPair(){
        int nbPair=0;
        return nbPair;
        }

        public boolean isAPair(){
            int indice=0,nbOcur=0,nbPair=0;
            for (Card c : Cards){
                for (int i=indice;i< 5;i++){
                    if (c.getValue()==Cards.get(i).getValue()) nbOcur++;
                }
                if (nbOcur == 2) nbPair++;
                if (nbOcur >= 3) return false;
                nbOcur=0; indice++;
            }
            return nbPair==1;
        }

        public boolean isAFull(){
            return this.isBrelan() && this.isAPair();
        }

    public boolean isBrelan(){
        int index=0,nbOcur=0,nbBrelan=0;
        for (Card c : Cards){
            for (int i=0;i< 5;i++){
                if (c.getValue()==Cards.get(i).getValue()) nbOcur++;
            }
            if (nbOcur == 3) {nbBrelan++;break;}
            nbOcur = 0;
        }
        return nbBrelan==1;
    }
    public boolean isCarre(){
        int index=0,nbOcur=0,nbCarre=0;
        for (Card c : Cards){
            for (int i=index;i< 5;i++){
                if (c.getValue()==Cards.get(i).getValue()) nbOcur++;
            }
            if (nbOcur == 4) {nbCarre++; break;}
            nbOcur=0;
        }
        return nbCarre==1;
    }

    public boolean isDeuxPaires(){
        return nbOccurPair()==2;
    }



    @Override
    public String toString() {

            String hand = null;
            for(int i = 0;i<getHand().size();i++)  hand += " "+getHand().get(i);
            return "Main : " + hand + ". Type : "+ getType();
    }
}
