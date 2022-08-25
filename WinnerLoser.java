
public class WinnerLoser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] elements = {'a','b','c','d','e'};
		int count = 1;
		int charCount = elements.length;
		for(int i = 0;; i++) {
			if(i>=elements.length) {
				i = -1;
				continue;
			}
			if(elements[i]=='#') {
				continue;
			}
			
			if(count%4==0 || count%10==4) {
				elements[i] = '#';
				charCount--;
				if(charCount==1) {
					break;
				}
			}
			
			count++;
		}
		
		for(char e : elements) {
			if(e!='#') {
				System.out.println(e);
				break;
			}
		}

	}

}
