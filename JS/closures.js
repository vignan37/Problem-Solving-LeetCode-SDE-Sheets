// Closures in JavaScript

// A closure is a function that has access to its own scope, the outer function's scope, and the global scope.

// Example of a closure
/* 
function x(){
    var a=9;
    function y(){
        console.log(a);
    }    
    y();
}
x(); 
*/
// Outputs: 9

//returning functions from other functions
/*
function x(){
    var a=9;
    function y(){
        console.log(a);
    }    
    return y;
}
var z = x();
z(); 
*/

// Outputs: 9

/* Updates to the closure variable
function x(){
    var a=9;
    function y(){
        console.log(a);
    }
    a=100;
    return y;
}
var z = x();
z(); 
*/
// Outputs: 9

function z(){
    var b=900;
    function x(){
        var a=9;
        function y(){
            console.log(a+b);
        }    
        y();
    }
    x();
}
z();

//more questions ankified