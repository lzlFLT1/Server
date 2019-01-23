public class FileSystemUti {

    // Delete
    public static Boolean delete(File file){
        File[] subFileAry = file.listFiles();
        if(subFileAry != null && subFileAry.length != 0){
            for (File item : subFileAry) {
                if(!delete(item)){
                    return false;
                }
            }
        }
        // 递归退出条件
        return file.delete();
    }

}
