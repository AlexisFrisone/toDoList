var app = angular.module("module", []); 
app.controller("myAppController", function($scope) {
    $scope.values = [];
	$scope.isEditTask=false;
    $scope.addValue = function () {
	
	/*inicializo el valor de error siempre para no arrastras la basura previa */
		$scope.logError= "";
				
		/*si el valor ingresado al scope ya existe salteo todo y seteo en logError el mensaje a mostrar*/
		if(!$scope.task){ 
			$scope.logError="No es posible agregar un valor vacio";
			return;
		}
		/* si el valor ingresado existe setea el error en logError */
		if($scope.values.indexOf($scope.task) == -1 ){
			$scope.values.push($scope.task);
	   }else{
			$scope.logError = "El valor ingresado ya existe"
	   }

    }
    $scope.removeTask = function (index) {
	/* despues de borrar el valor con en el indice que paso 
		seteo logError a vacio*/
        $scope.values.splice(index, 1);
		$scope.logError = "";
    }
	
	$scope.editTask = function (index , newValue) {
	/* Funcion no desarrollada */
		$scope.values[index]=newValue;
		$scope.logError = "";
    }
	$scope.isEditTask = function(){
		return $scope.isEditTask;
	}
	
	$scope.disabledEditTask = function(){
		return $scope.isEditTask = true;

	}
	$scope.enabledEditTask = function(){
		return $scope.isEditTask=false;
	}
}
);