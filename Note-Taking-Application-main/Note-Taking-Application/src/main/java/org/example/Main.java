package org.example ;
import java.util.Scanner;

class Queue {
    public static long fact(int n){
        if(n==0){
            return 1;

        }else
            return n*fact(n-1);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method


        Scanner input=new Scanner(System.in);
        boolean i=true;
        System.out.println("choose Model");
        System.out.println("**************");

        while(i){

            System.out.println("a)M/M/1 Model");
            System.out.println("b)M/M/1/k Model");
            System.out.println("c)M/M/c Model");
            System.out.println("d)M/M/c/k Model");
            System.out.println("e)exit");


            String x=input.nextLine();


            switch(x){
                case "a":
                    System.out.println("enter arrival rate");
                    double ar=input.nextDouble();
                    System.out.println("enter service rate");
                    double sr=input.nextDouble();
                    if(ar<sr){
                        double L=ar/(sr-ar);
                        double Lq=Math.pow(ar, 2)/(sr*(sr-ar));
                        double W=L/ar;
                        double Wq=Lq/ar;

                        System.out.println("L="+L+" "+"Lq="+Lq+" "+"W="+W+" "+"Wq="+Wq);

                        break;}
                    else

                        System.out.println(" the service rate must be better than arrival rate ");

                    break;
                case "b":
                    System.out.println("enter arrival rate");
                    ar=input.nextDouble();
                    System.out.println("enter service rate");
                    sr=input.nextDouble();
                    System.out.println("enter k");
                    int k=input.nextInt();
                    double R=ar/sr;
                    double L,Lq,W,Wq,ar_,pk;
                    if(R==1){
                        L=k/2;
                        pk=1/k+1;

                    }else{
                        pk=Math.pow(R, k)*(1-R)/(1-Math.pow(R,k+1 ));
                        //	L=r*(1-((k+1)*Math.pow(r, k))+(k*(Math.pow(r,k+1)))/(1-r)*(1-Math.pow(r,k-1)));
                        double L0=R*((1-((k+1)*Math.pow(R, k))+(k*Math.pow(R, k+1))));
                        double L1=(1-R)*(1-Math.pow(R,k+1));
                        L=L0/L1;}
                    ar_=ar*(1-pk);
                    W=L/ar_;
                    Wq=W-(1/sr);
                    Lq=ar_*Wq;
                    System.out.println("L="+L+" "+"Lq="+Lq+" "+"W="+W+" "+"Wq="+Wq);


                    break;
                case"c":
                    System.out.println("enter arrival rate");
                    ar=input.nextDouble();
                    System.out.println("enter service rate");
                    sr=input.nextDouble();
                    System.out.println("enterr c");
                    int c=input.nextInt();
                    double r=ar/sr;
                    double p0;
                    if(r/c<1){
                        p0=c*Math.pow(r,c)/(fact(c)*(c-r));
                        for(int n=0;n<=c-1;n++)	{
                            double p01=(Math.pow(r,n))/fact(n);
                            p0+=p01;
                        }
                        p0=Math.pow(p0, -1);

                        double Lq0=p0*Math.pow(r, c+1)/c;

                        double Lq1=fact(c)*Math.pow((1-r)/c, 2);
                        Lq=Lq0/Lq1;



                    }else{
                        p0=(Math.pow(r,c)/fact(c))*(c*sr)/(c*sr-ar);
                        for(int n=0;n<=c-1;n++){
                            double p01=(Math.pow(r,n))/fact(n);
                            p0+=p01;
                        }
                        p0=Math.pow(p0, -1);




                        Lq=(Math.pow(r, c-1)/(c*fact(c)*(Math.pow((1-r)/c, 2))))*p0;}
                    Wq=Lq/ar;
                    W=Wq+(1/sr);
                    L=Lq+r;
                    System.out.println("L="+L+" "+"Lq="+Lq+" "+"W="+W+" "+"Wq="+Wq);

                    break;
                case"d":
                    System.out.println("enter arrival rate");
                    ar=input.nextDouble();
                    System.out.println("enter service rate");
                    sr=input.nextDouble();
                    System.out.println("enrer c");
                    c=input.nextInt();
                    System.out.println("enrer k");
                    k=input.nextInt();
                    r=ar/sr;
                    R=r/c;

                    if(R==1){


                        p0=(Math.pow(r, c)/fact(c))*(k-c+1);

                        for(int n=0;n<=c-1;n++){
                            double p01=(Math.pow(r,n))/fact(n);
                            p0+=p01;


                        }}else{

                        p0=(Math.pow(r, c)/fact(c))*((1-Math.pow(R,k-c+1))/(1-R));

                        for(int n=0;n<=c-1;n++){
                            double p01=(Math.pow(r,n))/fact(n);
                            p0+=p01;
                        }}
                    p0=Math.pow(p0, -1);
                    pk=(Math.pow(R, k)*Math.pow(c, c)/fact(c))*p0;


                    double Lq0=(p0*R*Math.pow(r,c))/(fact(c)*Math.pow(1-R, 2));
                    System.out.println(Lq0);

                    double Lq1=1-Math.pow(R,k-c+1)-((1-R)*(k-c+1)*Math.pow(R,k-c));
                    System.out.println(Lq1);

                    Lq=Lq0*Lq1;
                    double sum=0;
                    for(int n=0;n<=c-1;n++){
                        sum+=((c-n)*Math.pow(r,n))/fact(n);

                    }
                    ar_=ar*(1-pk);

                    L=Lq+c-(p0*sum);
                    W=L/ar_;
                    Wq=Lq/ar_;


                    System.out.println("L="+L+" "+"Lq="+Lq+" "+"W="+W+" "+"Wq="+Wq);
                    //	System.out.println(p0);


                    break;

                case "e":
                    i=false;

                    break;
                default:
                    System.out.println("try again");

                    break;

            }
        }


    }
}

