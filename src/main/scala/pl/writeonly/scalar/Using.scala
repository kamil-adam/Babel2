object Using{
02.    def using[A <: {def close(): Unit}, B](param: A)(f:A => B): B = {
03.       try{
04.          f(param)
05.       } finally {
06.          param.close();
07.       }
08.    }
09.}