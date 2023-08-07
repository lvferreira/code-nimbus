package demopack;

public class AustralianTrafic implements CentralTraffic {

public static void main(String[] args) {
// TODO Auto-generated method stub
CentralTraffic a = new AustralianTrafic();
a.redStop();
a.flashYellow();
a.greenGo();

AustralianTrafic at = new AustralianTrafic();
//ContinentalTraffic ct = new AustralianTrafic();
at.walkOnSymbol();
//ct.TrainSymbol();
}

@Override
public void redStop() {
// TODO Auto-generated method stub
System.out.println(" redstop implementation");
}
public void walkOnSymbol()
{
System.out.println("walking");
}

@Override
public void flashYellow() {
// TODO Auto-generated method stub
System.out.println(" flash yellow implementation");
//code
}

@Override
public void greenGo() {
// TODO Auto-generated method stub
System.out.println(" Green go implementation");
}

//@Override
//public void TrainSymbol() {
//// TODO Auto-generated method stub
//}

}