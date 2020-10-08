package ricoweb;

public class RicoWebDto	{


  //+----+--------------+---------+--------------+-----------------------+-----------------+-----------------------+---------------------------------+
  //| id | company_name | address | station      | mainlink              | sublink         | accessinf             | message                         |
  //+----+--------------+---------+--------------+-----------------------+-----------------+-----------------------+---------------------------------+
  //|  1 | 会社名       | 住所    | 最寄り駅     | 会社WebサイトURL      | 求人情報URL     | 企業訪問・面談                   |メッセージ
  //+----+--------------+---------+--------------+-----------------------+-----------------+-----------------------+---------------------------------+


  //+--------------+--------------+------+-----+---------+----------------+
  //| Field        | Type         | Null | Key | Default | Extra          |
  //+--------------+--------------+------+-----+---------+----------------+
  //| id           | int          | NO   | PRI | NULL    | auto_increment |
  //| company_name | varchar(50)  | YES  |     | NULL    |                |
  //| address      | varchar(100) | YES  |     | NULL    |                |
  //| station      | varchar(20)  | YES  |     | NULL    |                |
  //| mainlink     | varchar(200) | YES  |     | NULL    |                |
  //| sublink      | varchar(200) | YES  |     | NULL    |                |
  //| accessinf    | varchar(100) | YES  |     | NULL    |                |
  //| message      | text         | YES  |     | NULL    |                |
  //+--------------+--------------+------+-----+---------+----------------+


		private int			id;					  //id
		private String	company_name; //
		private String	address;			//
		private String	station;		  //
		private String	mainlink;	    //
		private String	sublink;			//
		private String	accessinf;		//
		private String	message;			//



		/*		*/
		public RicoWebDto(){}

		/*		*/
		RicoWebDto(int id,String company_name,	String address,	String station,	String mainlink,String sublink,String accessinf,String message){
				this.id							=id;
        this.company_name =company_name;
        this.address =	address;			//
        this.station = station;		  //
        this.mainlink = mainlink;	    //
        this.sublink = sublink;			//
				this.accessinf = accessinf;	    //
        this.message = message;
		}

		/*		*/
		public void setId(int id){
				this.id = id;
		}
		public int getId(){
				return this.id;
		}

		public void setCompany_name(String company_name){
				this.company_name = company_name;
		}
		public String getCompany_name(){
				return this.company_name;
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


		public void setAccessinf(String accessinf){
				this.accessinf = accessinf;
		}
		public String getAccessinf(){
				return this.accessinf;
		}

		public void setMessage(String message){
				this.message= message;
		}
		public String getMessage(){
				return this.message;
		}

}
