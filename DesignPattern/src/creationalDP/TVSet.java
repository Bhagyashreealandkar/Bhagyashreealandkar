package creationalDP;

public class TVSet {

	private static volatile TVSet tvSetInstance = null;

//	public TVSet() {}
	private TVSet() {
		System.out.println("tvSetInstance obj created time call");
	}

//	public static TVSet getTvSetInstance() {
//		if (tvSetInstance == null) {
//			tvSetInstance = new TVSet();
//		}
//		return tvSetInstance;
//	}

//	public synchronized static TVSet getTvSetInstance() {
//		if (tvSetInstance == null) {
//			tvSetInstance = new TVSet();
//		}
//		return tvSetInstance;
//	}

//	public synchronized static TVSet getTvSetInstance() {
//		if (tvSetInstance == null) {
//			synchronized (TVSet.class) {// t1 t2 -- both threads are waiting here t1 ko access miila null mila usne obj
//										// create kiya ,,,uske bad t2 ko accesss mila usne bhi object create kr diya
//										// isliye yha bhi null check add kr diya h
//				tvSetInstance = new TVSet();
//			}
//
//		}
//		// heavy work done here
//		return tvSetInstance;
//	}



	public synchronized static TVSet getTvSetInstance() {
		if (tvSetInstance == null) { // optimization
			synchronized (TVSet.class) {//t1  t2 -- both threads are waiting here t1 ko access miila null mila usne obj create kiya ,,,uske bad t2 ko accesss mila usne bhi object create kr diya isliye yha bhi null check add kr diya h... toh t2 will not create object again and simply return andcode optimize ho jayega  
				if (tvSetInstance == null) { // double checking
					tvSetInstance = new TVSet();
				}
				
			}
		}
		//heavy work done here 
		return tvSetInstance;
	}

}

/*
 * suppose ek family h usme ek tv h and ek member ka dekhke honeke bad dusra
 * member tv dekh payega so if i created object and print simply to wo diff
 * objects print krega for that ste1: constructor private - so client cant
 * access the constructor but how should driver class get the object of TVSet-->
 * create emethod which will give us instance and which will return constructor
 * hm obj nhi bna skte method ka kyunki consructor private, h isliye method ko
 * static bna dege toh obj bnaneki jrurt nhi pdegi
 * 
 * 
 * 
 * 
 * without synchornized tvset instance ekbar he bar call krega getinstace method ko toh unko object null  milega due to this reason2 bar constructor call hoga and 2 bar object create hoga 
 * 
 * agr mai method ko synchronized bna du toh t1 ayega dekhega ki method kisi thread ne block kiya h kya kiya h toh whi stop ho jayega 
 * pr agr mai block ko sync krti hu toh wo check krega and bs jake heavy wok perform kr dega block krneke jgh pr
 */
