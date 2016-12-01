package com.example.akhonin.bazilio;

//public class Auth extends HttpService{
//    private String passHash;
//
////    public void Login(String login,String password) throws IOException, ExecutionException, InterruptedException {
////        MD5Digest m = new MD5Digest();
////        try {
////            passHash = m.main("1WlpIy1AKXOnM8sQxj8H6");
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////
////        try {
////            this.header.put("method", "Authentication");
////            this.header.put("hash", "akhonin+dcd5311b8bf752b0846666441677f5ca+2016-11-28T12:02:38+192.168.14.55");
////        } catch (JSONException e) {
////            e.printStackTrace();
////        }
////
////       // this.header = {"Authentication": "akhonin+dcd5311b8bf752b0846666441677f5ca+2016-11-28T12:02:38+192.168.14.55"};
////       // String test = this.sendGetRequest("Users/akhonin");
////        String test = this.sendGetRequest("Users/parants");
////
////        System.out.println("passHash===============" + passHash);
//////        System.out.println("password===============" + password);
////        System.out.println("test===============" + test);
////    }
//
//    public boolean checkUser() {
//        return true;
//    }
//
//    public boolean login(String login, String pass) throws Exception {
//        String user = this.sendGetRequest("users/"+login);
//        boolean reson = false;
//        if(user!=null) {
//            MD5Digest m = new MD5Digest();
//            JSONObject obj = new JSONObject(user);
//            String hash = (String) obj.get("PasswordHash");
//            if(hash.equals(m.main(pass+"WlpIy1AKXOnM8sQxj8H6"))){
//                reson = true;
//            }
//        }
//        return reson;
//    }
//}