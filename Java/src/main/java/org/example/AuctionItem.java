package org.example;

public class AuctionItem {
    private double auctionPrice=0;
    private double auctionNumber=0;
    private Boolean acceptedAuction=Boolean.FALSE;
    private String auctionType;
    public AuctionItem(item item){
        this.auctionPrice=item.getValue();
        this.auctionType=item.getType();


    }
    public void outbid(){
        if (this.auctionNumber<3 && this.acceptedAuction==Boolean.FALSE){
            this.auctionPrice=this.auctionPrice*1.10;
            this.auctionNumber+=1;
            if (this.auctionNumber>=3){
                this.acceptedAuction= Boolean.TRUE;
            }
        }


        if (this.acceptedAuction==Boolean.TRUE){
            System.out.println("l'enchère a bien été prise en compte et a été acceptée car c'est la troisième");
        }
        else {
            System.out.println("l'enchère a bien été prise en compte.");
        }

    }

    public double getAuctionPrice(){
        return this.auctionPrice;
    }
}
