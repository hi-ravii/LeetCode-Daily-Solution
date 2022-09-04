// Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

// Machine 1 (sender) has the function:

// string encode(vector strs) {
//   // ... your code
//   return encoded_string;
// }
// Machine 2 (receiver) has the function:
// vector decode(string s) {
//   //... your code
//   return strs;
// }
// So Machine 1 does:

// string encoded_string = encode(strs);
// and Machine 2 does:

// vector strs2 = decode(encoded_string);
// strs2 in Machine 2 should be the same as strs in Machine 1.

// Implement the encode and decode methods.

// Note:
// The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
// Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
// Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode al


EXPLANATION IN COPY

class Solution{
    public String encode (List<String> str){
        StringBuilder sb = new StringBuilder();
        for(String s:str){
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }
    public List<String> decode(String s){
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<s.length()){
            int j=1;
            while(s.charAt(j)!='#')j++;
            int length = Integer.parseInt(s.substring(i,j));
            i=j+1+length;
            res.add(s.substring(j+1,i));
        }
        return res;
    }
}
