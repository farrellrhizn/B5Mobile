<?php 

header('Content-Type: application/jsont/html; charset=utf-8');
include('koneksi.php');

if ($_SERVER['REQUEST_METHOD']==='POST'){
    $Password = $_POST['Password'];
    $idPembeli = $_POST['idPembeli'];

    $query = "UPDATE pembeli SET Password = '$Password' WHERE idPembeli = '$idPembeli'";
    $result = mysqli_query($konek, $query);
    $check = mysqli_affected_rows($konek);

    if ($check>0){
        $response['kode'] = 1;
        $response["message"] = "Data Tersedia";
        $response["data"] = array();

    }
    else{
        $response['kode'] = 0;
        $response["message"] = "Data Tidak Tersedia";
        $response["data"] = null;
    }

    echo json_encode($response);
    mysqli_close($konek);
}
?>