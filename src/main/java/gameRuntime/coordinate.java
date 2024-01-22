// package gameRuntime;

// import java.io.IOException;

// public class coordinate {

//     private Integer[] coor = null;
    
//     public coordinate(){}

//     public coordinate(Integer[] coor){
//         this.coor = coor;
//     }

//     public void setCoordinate(Integer[] coor) throws IOException{
//         if(!(this.coor == null)){
//             throw new IOException("Coordinate already defined");
//         }
//         this.coor = coor;
//     }

//     public Integer[] getCoordinate() throws IOException{
//         if(this.coor == null){
//             throw new IOException("Coordinate not defined");
//         }
//         return this.coor;
//     }

//     private Integer[] getTransCoordinate(){
//         Integer[] transCoor = {this.coor[0], this.coor[1] + (this.coor[0] + 1) / 2};
//         return transCoor;
//     }

// }

// [15, 15]
// [1, 0]

// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1], 
// -1, -1, -1, -1, -1, -1, -1,  1, -1, -1, -1, -1, -1, -1, -1], 
// -1, -1, -1, -1, -1, -1,  1,  1, -1, -1, -1, -1, -1, -1, -1], 
// -1, -1, -1, -1, -1, -1,  0,  1,  1, -1, -1, -1, -1, -1, -1], 
// -1, -1, -1, -1, -1,  1,  1,  1,  1, -1, -1, -1, -1, -1, -1], 
// -1,  0,  0,  0,  0,  0,  0,  1,  0,  0,  0,  0,  0,  0, -1], 
// -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1], 
// -1, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1], 
// -1, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1, -1], 
// -1, -1, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1, -1], 
// -1, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1, -1], 
// -1, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1],
// -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1], 
// -1,  0,  0,  0,  2,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1], 
// -1, -1, -1, -1, -1,  0,  2,  2,  2, -1, -1, -1, -1, -1, -1], 
// -1, -1, -1, -1, -1, -1,  2,  2,  2, -1, -1, -1, -1, -1, -1], 
// -1, -1, -1, -1, -1, -1,  2,  2, -1, -1, -1, -1, -1, -1, -1], null, null]