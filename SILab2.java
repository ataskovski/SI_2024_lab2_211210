public class SILab2 {
    public static boolean checkCart(List<Item> allItems, int payment){
        if (allItems == null){//A
            throw new RuntimeException("allItems list can't be null!");//B
        }

        float sum = 0;//C
//            C1            C2               C3
        for (int i = 0; i < allItems.size(); i++){
            Item item = allItems.get(i);//D
            if (item.getName() == null || item.getName().length() == 0){
                item.setName("unknown");//E
            }
            if (item.getBarcode() != null){//F
                String allowed = "0123456789";
                char chars[] = item.getBarcode().toCharArray();//G
                //       G1           G2                        G3
                for (int j = 0; j < item.getBarcode().length(); j++){
                    char c = item.getBarcode().charAt(j);
                    if (allowed.indexOf(c) == -1){//H
                        throw new RuntimeException("Invalid character in item barcode!");//I
                    }
                }
                if (item.getDiscount() > 0){//J
                    sum += item.getPrice()*item.getDiscount();//K
                }
                else {
                    sum += item.getPrice();//L
                }
            }
            else {
                throw new RuntimeException("No barcode!");//M
            }
            if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){//N
                sum -= 30;//O
            }
        }
        if (sum <= payment){//P
            return true;//Q
        }
        else {
            return false;//R
        }
    }//S
}