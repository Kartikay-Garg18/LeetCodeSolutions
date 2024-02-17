class Solution {
    public String intToRoman(int num) {
        String str = "";
        while(num>0){
            if(num>=900){
                if (num>=1000){
                    for (int i = 0; i < num/1000; i++) {
                        str+="M";
                    }
                    num%=1000;
                }
                if (num>=900){
                    str+="CM";
                    num%=900;
                }
            }
            if(num>=400){
                if (num>=500){
                    for (int i = 0; i < num/500; i++) {
                        str+="D";
                    }
                    num%=500;
                }
                if (num>=400){
                    str+="CD";
                    num%=400;
                }
            }
            if(num>=90){
                if (num>=100){
                    for (int i = 0; i < num/100; i++) {
                        str+="C";
                    }
                    num%=100;
                }
                if (num>=90){
                    str+="XC";
                    num%=90;
                }
            }
            if(num>=40){
                if (num>=50){
                    for (int i = 0; i < num/50; i++) {
                        str+="L";
                    }
                    num%=50;
                }
                if (num>=40){
                    str+="XL";
                    num%=40;
                }
            }
            if(num>=9){
                if (num>=10){
                    for (int i = 0; i < num/10; i++) {
                        str+="X";
                    }
                    num%=10;
                }
                if (num==9){
                    str+="IX";
                    num%=9;
                }
            }
            if(num>=4){
                if (num>=5){
                    for (int i = 0; i < num/5; i++) {
                        str+="V";
                    }
                    num%=5;
                }
                if (num==4){
                    str+="IV";
                    num%=4;
                }
            }
            if (num>0){
                for (int i = 0; i < num; i++) {
                    str+="I";
                }
                num=0;
            }
        }
        return str;
    }
}
