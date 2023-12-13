import java.io.*;
import java.util.*;

public class Main {
    static HashMap<Character, Integer> hm = new HashMap<>();
    static char[][] cipher = new char[5][5];
    static String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
    static StringBuilder sb = new StringBuilder();
    static StringBuilder ans = new StringBuilder();
    static ArrayList<String> dividedChar = new ArrayList<>();
    public static void main(String[] args) throws Exception{
      for(int i = 0; i < 25; i++){
        hm.put(alphabet.charAt(i), 0);
      }
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String message = br.readLine();
      String key = br.readLine();
      // make cipher key array
      makeCipherKeyArray(key);
      // for(int k = 0; k < 5; k++)
      //   System.out.println(Arrays.toString(cipher[k]));
      // divide 2chars
      divideToChars(message);
      // check Conditions
      for(String cur : dividedChar){
        boolean flag = false;
        char first = cur.charAt(0);
        char second = cur.charAt(1);
        // 1 condition 같은 행에 존재하면 오른쪽으로 한칸 이동한 글자로 암호화
        for(int i = 0; i < 5; i++){
          if (checkRow(i, first, second)){
            flag = true;
          }
        }
        // System.out.println("first" + first + second + flag);
        if (flag) continue;
        // 2 condition
        for(int i = 0; i < 5; i++){
          if (checkCol(i, first, second)){
            flag = true;
          }
        }
        // System.out.println("second" + first + second + flag);
        if (flag) continue;
        // 3 condition
        checkThird(first, second);
        // System.out.println("third" + first + second);
        
      }
      System.out.println(ans.toString());
    }
    public static void makeCipherKeyArray(String key){
      int idx = 0;
      for(int i = 0; i < key.length(); i++){
        char cur = key.charAt(i);
          if (hm.get(cur) == 0){
            hm.put(cur, 1);
            cipher[idx/5][idx%5] = cur;
            idx++;
          }
        }
      for(int i = 0; i < 25; i++){
        char cur = alphabet.charAt(i);
        if (hm.get(cur) == 0){
          cipher[idx/5][idx%5] = cur;
            idx++;
        }
      }
    }
  public static void divideToChars(String message){
    for(int i = 0; i < message.length(); i++){
        sb.append(message.charAt(i));
        if (sb.length() == 2){
          check();
        }
      }
      if (sb.length() == 1){
        sb.append("X");
        dividedChar.add(sb.toString());
      }
      // System.out.println(dividedChar);
  }
  public static void check(){
    StringBuilder word = new StringBuilder();
    char first = sb.charAt(0);
    char second = sb.charAt(1);
    if (first == second){
      word.append(first);
      if (first != 'X'){
        word.append("X");
      }else if (first == 'X'){
        word.append("Q");
      }
      dividedChar.add(word.toString());
      sb = new StringBuilder();
      sb.append(second);
    }else{
      dividedChar.add(sb.toString());
      sb = new StringBuilder();
    }
  }
  public static boolean checkRow(int i, char first, char second){
    StringBuilder temp = new StringBuilder();
    int firstIdx = -1;
    int secondIdx = -1;
    for(int j = 0; j < 5; j++){
      if (cipher[i][j] == first){
        firstIdx = j;
      }
      if (cipher[i][j] == second){
        secondIdx = j;
      }
    }
    if (firstIdx >= 0 && secondIdx >= 0){
      // System.out.println("firstIdx " + firstIdx + " secondIdx" + secondIdx);
      temp.append(cipher[i][ (firstIdx + 1) % 5]);
      temp.append(cipher[i][ (secondIdx + 1) % 5]);
      ans.append(temp);
      return true;
    }
    return false;
  }

  public static boolean checkCol(int i, char first, char second){
    StringBuilder temp = new StringBuilder();
    int firstIdx = -1;
    int secondIdx = -1;
    for(int j = 0; j < 5; j++){
      if (cipher[j][i] == first){
        firstIdx = j;
      }
      if (cipher[j][i] == second){
        secondIdx = j;
      }
    }
    if (firstIdx >= 0 && secondIdx >= 0){
      temp.append(cipher[ (firstIdx + 1) % 5][i]);
      temp.append(cipher[ (secondIdx + 1) % 5][i]);
      ans.append(temp);
      return true;
    }
    return false;
  }
  public static void checkThird(char first, char second){
    StringBuilder temp = new StringBuilder();
    int firstRow = -1;
    int firstCol = -1;
    int secondRow = -1;
    int secondCol = -1;
    for(int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        if (cipher[i][j] == first){
          firstRow = i;
          firstCol = j;
        }else if (cipher[i][j] == second){
          secondRow = i;
          secondCol = j;
        }
      }
    }
        if (firstRow >= 0 && secondRow >= 0 && firstCol >= 0 && secondCol >= 0){
    temp.append(cipher[firstRow][secondCol]);
    temp.append(cipher[secondRow][firstCol]);
    // System.out.println(temp);
    ans.append(temp);
          }
  }
  //0,1 -> 3,0
  //4,1 -> 4,4
}
