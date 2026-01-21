function x() {
  var a = 7;
  function y() {
    console.log(a);
  }
  return y;
}
var z = x();
console.log(z);
z();


// function z(){
//     var b=900;
//     function x(){
//         var a=9;
//         var d=8;
//         function y(){
//             console.log(a);
//         }    
//         y();
//     }
//     x();
// }
// z();