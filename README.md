# possess
use possess to create a timer chronograph


i write this for my test, maybe i will use this.
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String str = "{name:1234, password:4444}";
        str = stringToAscii(str);
        System.out.println(str+"woshi");
        str = asciiToString2(str);
        System.out.println(str+"nishi");

    }

    public static String stringToAscii(String value){
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for(int i=0; i<chars.length-1; i++){
            sbu.append((int)chars[i]).append(",");
        }
        sbu.append((int)(chars[chars.length-1]));
        return sbu.toString();
    }

    public static String asciiToString(String value){
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for(int i=0; i<chars.length; i++){
            sbu.append((char)Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }

    public static String asciiToString2(String value)
    {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }
