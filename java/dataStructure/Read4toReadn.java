/** The API: int read4(char *buf) reads 4 characters at a time from a file.
*
* The return value is the actual number of characters read. For example, 
* it returns 3 if there is only 3 characters left in the file.
*
* By using the read4 API, implement the function int read(char *buf, int n) 
* that reads n characters from the file.
*
* public int read(char[] buf, int n)
*/

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (buffPtr == 0) {
                buffCnt = read4(buff);
            }
            if (buffCnt == 0) break;
            while (ptr < n && buffPtr < buffCnt) {
                buf[ptr++] = buff[buffPtr++];
            }
            if (buffPtr >= buffCnt) buffPtr = 0;
        }
        return ptr;
    }

    // original solution
    private char[] lastBuf = new char[1000];
    private int lastcount = 0;
    private int lastoffset = 0;
    public int read(char[] buf, int n) {
        char[] tmpbuf = new char[4];
        int count = 0;
        while(lastoffset < lastcount){
            if(count == n)
                return count;
            buf[count++] = lastBuf[lastoffset++];
        }
        lastcount = 0;
        lastoffset = 0;
        while(count < n){
            int tmp = read4(tmpbuf);
            if(tmp == 0)
                return count;
            for(int i = 0; i < tmp; i++){
                buf[count++] = tmpbuf[i];
                if(count == n){
                    i++;
                    while(i < tmp){     // flush the remaining
                        lastBuf[lastcount++] = tmpbuf[i++];
                    }
                    return count;
                }
            }
        }
        return count;
    }
}