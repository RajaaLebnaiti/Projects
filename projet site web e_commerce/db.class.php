<?php 
class DB{
    //private on peut pas les acceder à l'exterieur

    private $host = 'localhost';
    private $username = 'root';
    private $password ='';
    private $database = 'ecommerce';
    private $db;

    //on va crée ici un constructeur
    
    public function __construct($host = null, $username = null, $password = null, $database = null){
        if($host != null){
            $this->host = $host;
            $this->username = $username;
            $this->password = $password;
            $this->$database = $database;
        }
        try{
            $this->db = new PDO('mysql:host='.$this->host.';dbname='.$this->database, $this->username,
            $this->password,array(
                PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES UTF8',
                PDO::ATTR_ERRMODE => PDO::ERRMODE_WARNING
            ));

        }catch(PDOException $e){
            die('<h1>Impossible de se connecter à la base de donnée</h1>');
        }
    
    }


    //fonction pourexecuter des requetes

    public function query($sql,$data=array()){
        $req=$this->db->prepare($sql);
        $req->execute($data);
        return $req->fetchAll(PDO::FETCH_OBJ);
    }
}