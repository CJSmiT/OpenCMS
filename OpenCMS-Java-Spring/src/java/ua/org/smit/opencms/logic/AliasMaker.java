/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.logic;

/**
 *
 * @author smit
 */
public class AliasMaker {
    
    public static String generatorAlies(String title) {
        if (title==null || title.isEmpty()) {
            throw new RuntimeException("EMPTY TITLE!!!");
        }
        char[] langRU = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л',
                'м','н','о','п','р','с','т','у','ф','х',
                'ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
        String[] langEN = {"a","b","v","g","d","ye","yo","zh","z","i","y","k",
                "l","m","n","o","p","r","s","t","u","f",
                "h","c","ch","sh","shch","","y","","e","u","ya"};
        StringBuilder result = new StringBuilder();
        char[] titleChar = title.toLowerCase().toCharArray();
        for(int i = 0;i < titleChar.length;i++){
            if(titleChar[i] >= 1072 && titleChar[i] <= 1103){
                for (int j = 0; j < langRU.length; j++) {
                    if(titleChar[i] == langRU[j]){
                        result.append(langEN[j]);
                    }
                }
            }else if(titleChar[i] >= 97 && titleChar[i] <= 122) {
                result.append(titleChar[i]);
            }else if(titleChar[i] >= 49 && titleChar[i] <= 57 || titleChar[i] == 48){
                result.append(titleChar[i]);
            }else if(titleChar[i] == 1169){ //ґ
                result.append("g");
            }else if(titleChar[i] == 1111){ //ї
                result.append("i");
            }else if(titleChar[i] == 1108){ //є
                result.append("e");
            }else if(titleChar[i] == 1110){ //і
                result.append("i");
            }else if(titleChar[i] == 1105){ //ё
                result.append("e");
            }else if (titleChar[i] == 32){
                result.append("_");
            }else {
                continue;
            }
        }
        String resultAlias = result.toString();
        if (resultAlias!=null && !resultAlias.isEmpty() && resultAlias.length()>250){
            resultAlias = resultAlias.substring(0, 250);
        }
        return resultAlias;
    }    
}
