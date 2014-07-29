

int greenLed = 10;
int yellowLed = 9;
int  redLed= 8;

void setup(){
Serial.begin(9600);
pinMode(greenLed,OUTPUT);
pinMode(yellowLed,OUTPUT);
pinMode(redLed,OUTPUT);



}

void loop(){
  
//check if the buffer is empty
if(Serial.available() > 0){
//store the input
int input = Serial.parseInt();

if(input == 1 || input == 2 || input == 3 ||input == 4 || input == 5 || input ==6){
turnLightOn(input);
Serial.println("i got: ");
Serial.println(input);
}
else{
Serial.println("invalid input: ");
Serial.println(input);
}

}
}

void turnLightOn(int state){

  //check if state is green light
if(state == 1){
turnLightsOff();
digitalWrite(greenLed, HIGH);
Serial.println("Green input: ");
Serial.println(state);
   

}
//check if state is yellow light
else if(state == 2){
turnLightsOff();
digitalWrite(yellowLed, HIGH);
Serial.println("yellow input: ");
Serial.println(state);

}
//check if state is red light
else if(state == 3){
turnLightsOff();
digitalWrite(redLed, HIGH);
Serial.println("red input: ");
Serial.println(state);

}else if(state == 4){
turnLightsOff();
Serial.println("off input: ");
Serial.println(state);
}
else if(state == 5){
turnLightsOff();
// loop from the lowest pin to the highest:
  for (int i = 0; i < 3; i++) { 
    Serial.println("buildin: ");
    // turn the pin on:
    digitalWrite(yellowLed, HIGH);   
    delay(500);                  
    // turn the pin off:
    digitalWrite(yellowLed, LOW);    
     delay(500);  
  }


Serial.println("building input: ");
Serial.println(state);
}

else if(state == 6){
turnLightsOff();

int randomNumber = random(8,11);
// loop from the lowest pin to the highest:
  for (int i = 0; i < 3; i++) { 
    Serial.println("awesome: ");
    // turn the pin on:
    digitalWrite(greenLed, HIGH);   
    delay(100);                  
    // turn the pin off:
    digitalWrite(greenLed, LOW);    
     delay(100);  
      // turn the pin on:
    digitalWrite(yellowLed, HIGH);   
    delay(100);                  
    // turn the pin off:
    digitalWrite(yellowLed, LOW);    
     delay(100);  
      // turn the pin on:
    digitalWrite(redLed, HIGH);   
    delay(100);                  
    // turn the pin off:
    digitalWrite(redLed, LOW);    
     delay(100);  
  }
  
  //random loop
  // loop from the lowest pin to the highest:
  for (int i = 0; i < 30; i++) { 
    Serial.println("random: ");
    Serial.println(randomNumber);
    
    // turn the pin on:
    digitalWrite(randomNumber, HIGH);   
    delay(100);                  
    
    randomNumber = random(8,11); 
    Serial.println("random: ");
    Serial.println(randomNumber);
    
    // turn the pin off:
    digitalWrite(randomNumber, LOW);    
    delay(100);  
     
      // turn the pin on:
    randomNumber = random(8,11);
    Serial.println("random: ");
  }
  
  
  
   for (int i = 0; i < 6; i++) { 
    Serial.println("awesome: ");
    // turn the pin on:
    digitalWrite(greenLed, HIGH);  
    digitalWrite(yellowLed, HIGH);  
     digitalWrite(redLed, HIGH); 
    delay(100);                  
    // turn the pin off:
    digitalWrite(greenLed, LOW);                     
    // turn the pin off:
    digitalWrite(yellowLed, LOW);    
    // turn the pin off:
    digitalWrite(redLed, LOW);    
     delay(100);  
  }


Serial.println("building input: ");
Serial.println(state);
}
else{
  Serial.println("invalid state");
Serial.println(state);
}

}

void turnLightsOff(){
digitalWrite(yellowLed, LOW);
digitalWrite(redLed, LOW);
digitalWrite(greenLed, LOW);
}

