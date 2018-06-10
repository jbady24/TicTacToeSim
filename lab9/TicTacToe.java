package lab9;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import java.util.Random;
import javafx.scene.layout.GridPane;

public class TicTacToe extends Application{
	
	// Create our two-dimensional array 
	//with three rows and three columns
	private int[][] _tGame = new int[3][3];
	
	// Creates a Random object
	private Random _random;
	
	// Creates our Image objects 
	//to hold our X and O images
	private Image _xImage = new Image(getClass().getResourceAsStream("x.jpg"));
	private Image _oImage = new Image(getClass().getResourceAsStream("o.jpg"));
	
	// Create a GridPane object
	private GridPane _gridP;
	
	// Creates our Label to display who won
	private Label _result;
	
	// Creates our ImageView objects
	private ImageView _imageView;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) 
	{
		// Instantiate our Label object
		_result = new Label();
		
		// Instantiate our GridPane object
		 _gridP = new GridPane();
		// Create a button
		Button button = new Button("CLICK");
		
		// Create an EventHandler
		button.setOnAction(event ->
		{
			ticTacToeSimulator();
		});
		
		// Create a VBox for our controls
		VBox vBox = new VBox(10, _gridP, button, _result);
		
		// Give our GridPane a center position
		_gridP.setAlignment(Pos.CENTER);
		
		_gridP.setPadding(new Insets(10));
		
		// Set our VBox position to center
		vBox.setAlignment(Pos.CENTER);
		
		// Give our VBox a padding of 10
		vBox.setPadding(new Insets(10));
		
		// Create a Scene
		Scene scene = new Scene(vBox);
		
		// Add our Scene to our Stage
		primaryStage.setScene(scene);
		
		// give our Stage a Title
		primaryStage.setTitle("Tic Tac Toe Lab");
		
		// Set our width and height for the Stage to 500
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
		
		// Show the window
		primaryStage.show();
	}
	
	public void ticTacToeSimulator() 
	{
		// Instantiate our Random Object
		_random = new Random();
		int randNum =0;
		// Loop through the first row of the array
		for(int row=0;row<_tGame.length;++row)
		{
			for(int col=0;col<_tGame[row].length;++col)
			{
				// Generates a random number 0, 1.
				randNum = _random.nextInt(2);
				// assign both rows and columns a random number
				_tGame[row][col] = randNum;
				
				if(randNum == 0)
					_imageView = new ImageView(_oImage);
				else 
					_imageView = new ImageView(_xImage);
				
				_gridP.add(_imageView, row,col );
			}
		}
		whoWins();
	}
	
	public void whoWins() 
	{
		boolean isOTrue = false;
		boolean isXTrue = false;
		
		// Check for O
		if(_tGame[0][0] == 0 && _tGame[0][1] == 0 && _tGame[0][2] == 0) 
			isOTrue = true;
		else if(_tGame[1][0] == 0 && _tGame[1][1] == 0 && _tGame[1][2] == 0) 
			isOTrue = true;
		else if(_tGame[2][0] == 0 && _tGame[2][1] == 0 && _tGame[2][2] == 0)
			isOTrue = true;
		else if(_tGame[0][0] == 0 && _tGame[1][0] == 0 && _tGame[2][0] == 0) 
			isOTrue = true;
		else if(_tGame[0][1] == 0 && _tGame[1][1] == 0 && _tGame[2][1] == 0) 
			isOTrue = true;
		else if(_tGame[0][2] == 0 && _tGame[1][2] == 0 && _tGame[2][2] == 0) 
			isOTrue = true;
		else if(_tGame[0][0] == 0 && _tGame[1][1] == 0 && _tGame[2][2] == 0)
			isOTrue = true;
		else if(_tGame[2][0] == 0 && _tGame[1][1] == 0 && _tGame[0][2] == 0)
			isOTrue = true;
		
		// Check for X
		if(_tGame[0][0] == 1 && _tGame[0][1] == 1 && _tGame[0][2] == 1) 
			isXTrue = true;
		else if(_tGame[1][0] == 1 && _tGame[1][1] == 1 && _tGame[1][2] ==1) 
			isXTrue = true;
		else if(_tGame[2][0] == 1 && _tGame[2][1] == 1 && _tGame[2][2] == 1) 
			isXTrue = true;
		else if(_tGame[0][0] == 1 && _tGame[1][0] == 1 && _tGame[2][0] == 1) 
			isXTrue = true;
		else if(_tGame[0][1] == 1 && _tGame[1][1] == 1 && _tGame[2][1] == 1) 
			isXTrue = true;
		else if(_tGame[0][2] == 1 && _tGame[1][2] == 1 && _tGame[2][2] == 1) 
			isXTrue = true;
		else if(_tGame[0][0] == 1 && _tGame[1][1] == 1 && _tGame[2][2] == 1)
			isXTrue = true;
		else if(_tGame[2][0] == 1 && _tGame[1][1] == 1 && _tGame[0][2] == 1)
			isXTrue = true;
		
		
		if(isOTrue == true && isXTrue == true) 
		{
			_result.setText("Tie");
		}
		else if(isOTrue == true && isXTrue == false) 
		{
			_result.setText("O Wins");
		}
		else if(isXTrue == true && isOTrue == false) 
		{
			_result.setText("X Wins");
		}
		else if(isOTrue == false && isXTrue == false)
		{
			_result.setText("No Winner");
		}
		
		
	}
}
