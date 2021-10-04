import java.io.IOException;
import java.util.ArrayList;

public class testData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		dataDriven dv = new dataDriven();
		ArrayList<String> data = dv.getData("Add Profile");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
	}

}
