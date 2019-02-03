package blackJack;

/* 
   Name: John A Chrin
   Course: CSC240-03
   Date: 2018/04/18
   Purpose: This program plays
   1-on-1 Black Jack.
*/

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

// Entire program inside of class.
public class BlackJack
{
	public static void main(String args[])
	{
		//Instantiating some string array's to hold player cards.
		String[] dealerHand = new String[10];
		String[] playerHand = new String[10];
		//This drafts up the actual deck.
		String[] cardDeck = deck();
		//This drafts up the value of each card in the deck.
		int[] value = valueCards();
		//This plays the game.
		dealer(cardDeck, dealerHand, playerHand, value);
	}

	//Actual deck, assisted by "makeEvenSpacing" to... make even spacing ha-ha...
	public static String[] deck()
	{
		String[] deckOfCards = new String[52];
		deckOfCards[0] = makeEvenSpacing("Ace of Hearts");
		deckOfCards[1] = makeEvenSpacing("2 of Hearts");
		deckOfCards[2] = makeEvenSpacing("3 of Hearts");
		deckOfCards[3] = makeEvenSpacing("4 of Hearts");
		deckOfCards[4] = makeEvenSpacing("5 of Hearts");
		deckOfCards[5] = makeEvenSpacing("6 of Hearts");
		deckOfCards[6] = makeEvenSpacing("7 of Hearts");
		deckOfCards[7] = makeEvenSpacing("8 of Hearts");
		deckOfCards[8] = makeEvenSpacing("9 of Hearts");
		deckOfCards[9] = makeEvenSpacing("10 of Hearts");
		deckOfCards[10] = makeEvenSpacing("Jack of Hearts");
		deckOfCards[11] = makeEvenSpacing("Queen of Hearts");
		deckOfCards[12] = makeEvenSpacing("King of Hearts");
		deckOfCards[13] = makeEvenSpacing("Ace of Diamonds");
		deckOfCards[14] = makeEvenSpacing("2 of Diamonds");
		deckOfCards[15] = makeEvenSpacing("3 of Diamonds");
		deckOfCards[16] = makeEvenSpacing("4 of Diamonds");
		deckOfCards[17] = makeEvenSpacing("5 of Diamonds");
		deckOfCards[18] = makeEvenSpacing("6 of Diamonds");
		deckOfCards[19] = makeEvenSpacing("7 of Diamonds");
		deckOfCards[20] = makeEvenSpacing("8 of Diamonds");
		deckOfCards[21] = makeEvenSpacing("9 of Diamonds");
		deckOfCards[22] = makeEvenSpacing("10 of Diamonds");
		deckOfCards[23] = makeEvenSpacing("Jack of Diamonds");
		deckOfCards[24] = makeEvenSpacing("Queen of Diamonds");
		deckOfCards[25] = makeEvenSpacing("King of Diamonds");
		deckOfCards[26] = makeEvenSpacing("Ace of Clubs");
		deckOfCards[27] = makeEvenSpacing("2 of Clubs");
		deckOfCards[28] = makeEvenSpacing("3 of Clubs");
		deckOfCards[29] = makeEvenSpacing("4 of Clubs");
		deckOfCards[30] = makeEvenSpacing("5 of Clubs");
		deckOfCards[31] = makeEvenSpacing("6 of Clubs");
		deckOfCards[32] = makeEvenSpacing("7 of Clubs");
		deckOfCards[33] = makeEvenSpacing("8 of Clubs");
		deckOfCards[34] = makeEvenSpacing("9 of Clubs");
		deckOfCards[35] = makeEvenSpacing("10 of Clubs");
		deckOfCards[36] = makeEvenSpacing("Jack of Clubs");
		deckOfCards[37] = makeEvenSpacing("Queen of Clubs");
		deckOfCards[38] = makeEvenSpacing("King of Clubs");
		deckOfCards[39] = makeEvenSpacing("Ace of Spades");
		deckOfCards[40] = makeEvenSpacing("2 of Spades");
		deckOfCards[41] = makeEvenSpacing("3 of Spades");
		deckOfCards[42] = makeEvenSpacing("4 of Spades");
		deckOfCards[43] = makeEvenSpacing("5 of Spades");
		deckOfCards[44] = makeEvenSpacing("6 of Spades");
		deckOfCards[45] = makeEvenSpacing("7 of Spades");
		deckOfCards[46] = makeEvenSpacing("8 of Spades");
		deckOfCards[47] = makeEvenSpacing("9 of Spades");
		deckOfCards[48] = makeEvenSpacing("10 of Spades");
		deckOfCards[49] = makeEvenSpacing("Jack of Spades");
		deckOfCards[50] = makeEvenSpacing("Queen of Spades");
		deckOfCards[51] = makeEvenSpacing("King of Spades");
		

		return deckOfCards;
	}
	//As said before in the main, this adds value to the cards, nothing to see here..
	public static int[] valueCards()
	{
		int[] value = new int[52];
		for(int i = 0; i<4; i++)
		{
			if(i==0)
			{
				value[0] = 1; 
				value[13] = 1;
				value[26] = 1;
				value[39] = 1;
			}
			value[1+(i*13)] = 2;
			value[2+(i*13)] = 3;
			value[3+(i*13)] = 4;
			value[4+(i*13)] = 5;
			value[5+(i*13)] = 6;
			value[6+(i*13)] = 7;
			value[7+(i*13)] = 8;
			value[8+(i*13)] = 9;
			value[9+(i*13)] = 10;
			value[10+(i*13)] = 10;
			value[11+(i*13)] = 10;
			value[12+(i*13)] = 10;

		}		
		return value;
	}
	//This is a nifty add-on that fixes the spacing of the cards so it prints better, made later because I didn't anticipate an issue. Million & one ways to fix a problem...
	private static String makeEvenSpacing(String card)
	{
		int size = 20;
		StringBuilder sb = new StringBuilder();
		sb.append(card);
		// add spacing to make every string equal in 'size'
		if (card.length() < size)
		{
			while (sb.toString().length() < size)
			{
				sb.append(" ");
			}
		}
		return sb.toString();
	}
	//This method generates random numbers in the range you want, I use this method inside the dealer method to randomly deal cards and not repeat deal the same card (that's impossible unless multiple decks).
	public static int getRandomInteger(int maximum, int minimum)
	{
		return ((int) (Math.random() * (maximum - minimum))) + minimum;
	}
	//This is the MEAT & POTATO's of the program, lots of situational IF's and ELSE's...
	public static void dealer(String[] deck, String[] dealerHand, String[] playerHand, int[] value)
	{
		//Vestigal left-over from previous card program
		int numOfCards = 2 * 10;
		//Random number arraylist, this decides which cards will be pulled from the deck.
		ArrayList<Integer> ranNum = new ArrayList<Integer>();
		while (ranNum.size() != numOfCards)
		{
			int num = getRandomInteger(52, 0);
			if (!ranNum.contains(num))
			{
				ranNum.add(num);
			}
		}

		//Unoptimized for-loop that grabs 10 random cards for each player and stores them (only revealed as the game progresses, which to be honest is completely fine for this game that basically plays itself)...
		for (int i = 0; i < 20; i++)
		{
			if (i<10)
			{
				dealerHand[i] = deck[ranNum.get(i)];
			}
			else
			{
				if(i==10)
				{
					playerHand[0] = deck[ranNum.get(i)];	
				}
				if(i==11)
				{
					playerHand[1] = deck[ranNum.get(i)];
				}
				if(i==12)
				{
					playerHand[2] = deck[ranNum.get(i)];	
				}
				if(i==13)
				{
					playerHand[3] = deck[ranNum.get(i)];
				}
				if(i==14)
				{
					playerHand[4] = deck[ranNum.get(i)];	
				}
				if(i==15)
				{
					playerHand[5] = deck[ranNum.get(i)];
				}
				if(i==16)
				{
					playerHand[6] = deck[ranNum.get(i)];	
				}
				if(i==17)
				{
					playerHand[7] = deck[ranNum.get(i)];
				}
				if(i==18)
				{
					playerHand[8] = deck[ranNum.get(i)];	
				}
				if(i==19)
				{
					playerHand[9] = deck[ranNum.get(i)];
				}

			}
		}
		//First text seen, shows you the dealer's hand.
		System.out.println("The dealers hand.");
		for (int i = 0; i < 2; i++)
		{
			System.out.print(dealerHand[i] + "|");
		}
		//Second text seen, shows you your hand.
		System.out.println();
		System.out.println("Your hand.");
		for (int i = 0; i < 2; i++)
		{
			System.out.print(playerHand[i] + "|");
		}
		System.out.println();
		System.out.println("____________________________________________________________________________________________________");
		//Time delay to let the game play out.
		try
		{
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Initialize VALUE holders for the cards each guy gets.
		int dealerValue = 0;
		int playerValue = 0;
		int a = 0;
		int b = 13;
		int c = 26;
		int d = 39;
		int[] countera = new int[] {0};
		int[] counterb = new int[] {0};
		int[] counterc = new int[] {0};
		int[] counterd = new int[] {0};
		
		//dealer value calculation.
		for(int i = 0; i<2;i++)
		{
			for(int j = 0; j<52; j++)
			{
				if(dealerHand[i] == deck[j])
				{
					dealerValue += value[j];
					//Check hand for ACES and if their value needs to change. This was awfully painful, and poorly optimized but it works!
					for(int k = 0; k<2; k++)
					{
						if(dealerHand[k] == deck[a] || dealerHand[k] == deck[b] || dealerHand[k] == deck[c] || dealerHand[k] == deck[d])
						{
							if(dealerValue<21 && ((dealerValue+10)<22))
							{
								if(dealerHand[k] == deck[a] && countera[0]==0)
								{
									dealerValue+=10;
									countera[0]+=1;
								}
								if(dealerHand[k] == deck[b] && counterb[0]==0)
								{
									dealerValue+=10;
									counterb[0]+=1;
								}
								if(dealerHand[k] == deck[c] && counterc[0]==0)
								{
									dealerValue+=10;
									counterc[0]+=1;
								}
								if(dealerHand[k] == deck[d] && counterd[0]==0)
								{
									dealerValue+=10;
									counterd[0]+=1;
								}
							}
							if(dealerValue>21 && countera[0] == 1)
							{
								dealerValue-=10;
								countera[0]-=1;
							}
							if(dealerValue>21 && counterb[0] == 1)
							{
								dealerValue-=10;
								counterb[0]-=1;
							}
							if(dealerValue>21 && counterc[0] == 1)
							{
								dealerValue-=10;
								counterc[0]-=1;
							}
							if(dealerValue>21 && counterd[0] == 1)
							{
								dealerValue-=10;
								counterd[0]-=1;
							}
						}
					}
					break;
				}
			}

		}
		//player value calculation.
		for(int i = 0; i<2;i++)
		{
			for(int j = 0; j<52; j++)
			{
				if(playerHand[i] == deck[j])
				{
					playerValue += value[j];
					//Check hand for ACES and if their value needs to change. This was awfully painful, and poorly optimized but it works!
					for(int k = 0; k<2; k++)
					{
						if(playerHand[k] == deck[a] || playerHand[k] == deck[b] || playerHand[k] == deck[c] || playerHand[k] == deck[d])
						{
							if(playerValue<21 && ((playerValue+10)<22))
							{
								if(playerHand[k] == deck[a] && countera[0]==0)
								{
									playerValue+=10;
									countera[0]+=1;
								}
								if(playerHand[k] == deck[b] && counterb[0]==0)
								{
									playerValue+=10;
									counterb[0]+=1;
								}
								if(playerHand[k] == deck[c] && counterc[0]==0)
								{
									playerValue+=10;
									counterc[0]+=1;
								}
								if(playerHand[k] == deck[d] && counterd[0]==0)
								{
									playerValue+=10;
									counterd[0]+=1;
								}
							}
							if(playerValue>21 && countera[0] == 1)
							{
								playerValue-=10;
								countera[0]-=1;
							}
							if(playerValue>21 && counterb[0] == 1)
							{
								playerValue-=10;
								counterb[0]-=1;
							}
							if(playerValue>21 && counterc[0] == 1)
							{
								playerValue-=10;
								counterc[0]-=1;
							}
							if(playerValue>21 && counterd[0] == 1)
							{
								playerValue-=10;
								counterd[0]-=1;
							}
						}
					}
					break;
				}
			}

		}
		
		boolean x = false;
		//decision making time. Super awesome section of code below that finds out who wins. This code doesn't account for the SPLIT option, but that requires betting to function..
		while(x == false)
		{
			for(int i = 2, q = 2; i<30;)
			{
				//Both get 21
				if(((dealerValue) == 21)&&((playerValue) == 21))
				{
					System.out.println("PUSH!");
					x = true;
					break;
				}
				//Player gets 21
				else if(playerValue == 21)
				{
					System.out.println("BLACK JACK! you win!");
					x = true;
					break;
				}
				//Dealer gets 21
				else if(dealerValue== 21)
				{
					System.out.println("BLACK JACK! but not for you, you lose, dealer wins!");
					x = true;
					break;
				}
				//Player has higher value than dealer, but not 21
				else if(playerValue > dealerValue)
				{
					System.out.println("The dealer has "+dealerValue+" you have "+playerValue+" the dealer hits.");
					//Time delay to let the game play out.
					try
					{
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (int j = 0; j < (i+1); j++)
					{
						System.out.print(dealerHand[j] + "|");
					}
					System.out.println();
					System.out.println();
					//Time delay to let the game play out.
					try
					{
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//dealer value calculation.
						for(int z = 0; z<52; z++)
						{
							if(dealerHand[i] == deck[z])
							{
								dealerValue += value[z];
								//Check hand for ACES and if their value needs to change. This was awfully painful, and poorly optimized but it works!
								for(int k = 0; k<i+1; k++)
								{
									if(dealerHand[k] == deck[a] || dealerHand[k] == deck[b] || dealerHand[k] == deck[c] || dealerHand[k] == deck[d])
									{
										if(dealerValue<21 && ((dealerValue+10)<22))
										{
											if(dealerHand[k] == deck[a] && countera[0]==0)
											{
												dealerValue+=10;
												countera[0]+=1;
											}
											if(dealerHand[k] == deck[b] && counterb[0]==0)
											{
												dealerValue+=10;
												counterb[0]+=1;
											}
											if(dealerHand[k] == deck[c] && counterc[0]==0)
											{
												dealerValue+=10;
												counterc[0]+=1;
											}
											if(dealerHand[k] == deck[d] && counterd[0]==0)
											{
												dealerValue+=10;
												counterd[0]+=1;
											}
										}
										if(dealerValue>21 && countera[0] == 1)
										{
											dealerValue-=10;
											countera[0]-=1;
										}
										if(dealerValue>21 && counterb[0] == 1)
										{
											dealerValue-=10;
											counterb[0]-=1;
										}
										if(dealerValue>21 && counterc[0] == 1)
										{
											dealerValue-=10;
											counterc[0]-=1;
										}
										if(dealerValue>21 && counterd[0] == 1)
										{
											dealerValue-=10;
											counterd[0]-=1;
										}
									}
								}
								i++;
								break;
							}
						}
					if(dealerValue==21)
					{
						System.out.println("The dealer has "+dealerValue+". Dealer BLACKJACK! you lose!");
						x = true;
						break;
					}
					else if(dealerValue>21)
					{
						System.out.println("The dealer has "+dealerValue+". Dealer bust, you win!");
						x = true;
						break;
					}
					else
					{
						continue;
					}
				}
				//Dealer has higher value than player, but not 21
				else if(playerValue < dealerValue)
				{
					System.out.println("The dealer has "+dealerValue+" you have "+playerValue+" you must hit or lose.");
					//Time delay to let the game play out.
					try
					{
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (int j = 0; j < (q+1); j++)
					{
						System.out.print(playerHand[j] + "|");
					}
					System.out.println();
					System.out.println();
					//Time delay to let the game play out.
					try
					{
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//player value calculation.
						for(int z = 0; z<52; z++)
						{
							if(playerHand[q] == deck[z])
							{
								playerValue += value[z];
								//Check hand for ACES and if their value needs to change. This was awfully painful, and poorly optimized but it works!
								for(int k = 0; k<q+1; k++)
								{
									if(playerHand[k] == deck[a] || playerHand[k] == deck[b] || playerHand[k] == deck[c] || playerHand[k] == deck[d])
									{
										if(playerValue<21 && ((playerValue+10)<22))
										{
											if(playerHand[k] == deck[a] && countera[0]==0)
											{
												playerValue+=10;
												countera[0]+=1;
											}
											if(playerHand[k] == deck[b] && counterb[0]==0)
											{
												playerValue+=10;
												counterb[0]+=1;
											}
											if(playerHand[k] == deck[c] && counterc[0]==0)
											{
												playerValue+=10;
												counterc[0]+=1;
											}
											if(playerHand[k] == deck[d] && counterd[0]==0)
											{
												playerValue+=10;
												counterd[0]+=1;
											}
										}
										if(playerValue>21 && countera[0] == 1)
										{
											playerValue-=10;
											countera[0]-=1;
										}
										if(playerValue>21 && counterb[0] == 1)
										{
											playerValue-=10;
											counterb[0]-=1;
										}
										if(playerValue>21 && counterc[0] == 1)
										{
											playerValue-=10;
											counterc[0]-=1;
										}
										if(playerValue>21 && counterd[0] == 1)
										{
											playerValue-=10;
											counterd[0]-=1;
										}
									}
								}
								q++;
								break;
							}
						}
					if(playerValue==21)
					{
						System.out.println("You have "+playerValue+". BLACKJACK! you win!");
						x = true;
						break;
					}
					else if(playerValue>21)
					{
						System.out.println("You have "+playerValue+". Bust, you lose.");
						x = true;
						break;
					}
					else
					{
						continue;
					}
				}
				else
				{
					System.out.println("You both have the same value hand "+dealerValue+", the dealer will draw.");
					//Time delay to let the game play out.
					try
					{
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (int j = 0; j < (i+1); j++)
					{
						System.out.print(dealerHand[j] + "|");
					}
					System.out.println();
					System.out.println();
					//Time delay to let the game play out.
					try
					{
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//dealer value calculation.
						for(int z = 0; z<52; z++)
						{
							if(dealerHand[i] == deck[z])
							{
								dealerValue += value[z];
								//Check hand for ACES and if their value needs to change. This was awfully painful, and poorly optimized but it works!
								for(int k = 0; k<i+1; k++)
								{
									if(dealerHand[k] == deck[a] || dealerHand[k] == deck[b] || dealerHand[k] == deck[c] || dealerHand[k] == deck[d])
									{
										if(dealerValue<21 && ((dealerValue+10)<22))
										{
											if(dealerHand[k] == deck[a] && countera[0]==0)
											{
												dealerValue+=10;
												countera[0]+=1;
											}
											if(dealerHand[k] == deck[b] && counterb[0]==0)
											{
												dealerValue+=10;
												counterb[0]+=1;
											}
											if(dealerHand[k] == deck[c] && counterc[0]==0)
											{
												dealerValue+=10;
												counterc[0]+=1;
											}
											if(dealerHand[k] == deck[d] && counterd[0]==0)
											{
												dealerValue+=10;
												counterd[0]+=1;
											}
										}
										if(dealerValue>21 && countera[0] == 1)
										{
											dealerValue-=10;
											countera[0]-=1;
										}
										if(dealerValue>21 && counterb[0] == 1)
										{
											dealerValue-=10;
											counterb[0]-=1;
										}
										if(dealerValue>21 && counterc[0] == 1)
										{
											dealerValue-=10;
											counterc[0]-=1;
										}
										if(dealerValue>21 && counterd[0] == 1)
										{
											dealerValue-=10;
											counterd[0]-=1;
										}
									}
								}
								i++;
								break;
							}
						}
					if(dealerValue==21)
					{
						System.out.println("The dealer has "+dealerValue+". Dealer BLACKJACK! you lose!");
						x = true;
						break;
					}
					else if(dealerValue>21)
					{
						System.out.println("The dealer has "+dealerValue+". Dealer bust, you win!");
						x = true;
						break;
					}
					else
					{
						continue;
					}		
				}
				
			}
		}
		
		
		

	}
}

// for loop draft up deck/ value with an output of a string