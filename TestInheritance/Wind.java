/**
2019年9月18日19:56:47
*/

class Instrument {
  public void play(){
    System.out.println("Insturment is playing");
  }
  static void tune(Instrument i){
    i.play();
  }
}

public class Wind extends Instrument{
  public static void main(String[] args){
    //Wind flute = new Wind();
    Instrument flute = new Wind(); /* this is also okay */
    Instrument.tune(flute); // Upcasting
  }
}