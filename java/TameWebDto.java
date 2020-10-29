package tamework;

public class TameWebDto	{



  //+--------------+--------------+------+-----+---------+----------------+
  //| Field        | Type         | Null | Key | Default | Extra          |
  //+--------------+--------------+------+-----+---------+----------------+
  //| id           | int          | NO   | PRI | NULL    | auto_increment |
  //| work_name 	 | varchar(50)  | YES  |     | NULL    |                |
  //| address      | varchar(100) | YES  |     | NULL    |                |
  //| station      | varchar(20)  | YES  |     | NULL    |                |
  //| mainlink     | varchar(200) | YES  |     | NULL    |                |
  //| sublink      | varchar(200) | YES  |     | NULL    |                |
  //| message      | text         | YES  |     | NULL    |                |
  //+--------------+--------------+------+-----+---------+----------------+


		private int			id;					  //id
		private String	work_name; //
		private String	address;			//
		private String	station;		  //
		private String	mainlink;	    //
		private String	sublink;			//
		private String	message;			//



		/*		*/
		public TameWebDto(){}

		/*		*/
		TameWebDto(int id,String work_name,	String address,	String station,	String mainlink,String sublink,String message){
				this.id							=id;
        this.work_name =work_name;
        this.address =	address;			//
        this.station = station;		  //
        this.mainlink = mainlink;	    //
        this.sublink = sublink;			//
        this.message = message;
		}

		/*		*/
		public void setId(int id){
				this.id = id;
		}
		public int getId(){
				return this.id;
		}

		public void setWork_name(String work_name){
				this.work_name = work_name;
		}
		public String getWork_name(){
				return this.work_name;
		}

		public void setAddress(String address){
				this.address= address;
		}
		public String getAddress(){
				return this.address;
		}

		public void setStation(String station){
				this.station= station;
		}
		public String getStation(){
				return this.station;
		}

		public void setMainlink(String mainlink){
				this.mainlink= mainlink;
		}
		public String getMainlink(){
				return this.mainlink;
		}

		public void setSublink(String sublink){
				this.sublink= sublink;
		}
		public String getSublink(){
				return this.sublink;
		}

		public void setMessage(String message){
				this.message= message;
		}
		public String getMessage(){
				return this.message;
		}

}
