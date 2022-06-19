boolean[] up = new boolean[26];
boolean[] down = new boolean[26];
char[] arr = str.toCharArray();
for(char c: arr){
    if(Character.isLowerCase(c)){
        down[c-'a'] = true;
    }
    if(Character.isUpperCase(c)){
        up[c-'A'] = true;
    }
    for(int i =25;i>=0;i--){
        if(up[i] && down[i]){
            return (char)('A'+i)+ "";
        }
    }
        return "";
