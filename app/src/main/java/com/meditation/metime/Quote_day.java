package com.meditation.metime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static java.lang.Math.toIntExact;

public class Quote_day extends BaseActivityWithDrawer {

    // enables drawer
    @Override
    public boolean shouldEnableDrawer() {
        return true;
    }

    ArrayList<String> quotes = new ArrayList<>(Arrays.asList("To be free from suffering, desire and negative emotions: that is enlightenment.",
            "Listen, rather than speak; observe, rather than rush by; be sensitive, rather than ego-driven. ",
            "For most of us, enlightenment does not come suddenly, but little by little, as we begin to understand more about ourselves and the world around us. ",
            "Life is a beautiful gift, if we only know how to receive it. ",
            "A person who is relaxed is extremely active on the exterior, but inside he is absolutely silent, absolutely relaxed and at ease. – Shri Mataji Nirmala Devi",
            "How far you go in life depends on your being tender with the young, compassionate with the aged, sympathetic with the striving and tolerant of the weak and strong. Because some day in life you will have been all of these. – George Washington Carver ",
            "Don’t seek to define enlightenment; it is indefinable, yet you will know it when it arrives.",
            "Not everything that is faced can be changed. But nothing can be changed until it is faced. – James Baldwin ",
            "No one, when he has lit a lamp, puts it in a cellar or under a basked, but on a stand, that those who come in may see the light- The Bible ",
            "To live with love and generosity is to live well. ",
            "The truth is sometimes spoken in words, and sometimes in silence. ",
            "Gaining self-respect is the first step on the path to enlightenment. ",
            "A bulb under the earth grows towards the light, in order to flower; in the same way, we move instinctively towards enlightenment.",
            "Live your life daily in a way that you never lose yourself. When you are carried away with your worries, fears, cravings, anger, and desire, you run away from yourself and you lose yourself. The practice is always to go back to oneself. – Thich Nhat Hanh ",
            "Your vision will become clear only when you can look into your own heart. – Carl Jung ",
            "Where do we find enlightenment? In a learned book; in a spiritual ritual; in contemplation; looking at a beautiful painting; or simply in the joy of being alive?",
            "Governing anger, and controlling the ego, are both crucial to becoming enlightened.",
            "You are the creator of the great experience you have. ",
            "Watch your thoughts; they become words. Watch your words; they become actions. Watch your actions; they become habits. Watch your habits; they become character. Watch your character; it becomes your destiny. – Lao Tzu ",
            "There are only two ways to live your life. One is as though nothing is a miracle. The other is as if everything is. – Albert Einstein ",
            "Better to light a candle than to curse the darkness. – Eleanor Roosevelt",
            "Attitude is a little thing that makes a big difference. – Winston Churchill",
            "When you feel angry, upset, or at odds with yourself, ask the question: What is it I want? You may find you already have more than you realized.",
            "The first and greatest victory is to conquer yourself – Plato",
            "Believe in yourself; accept what you are, and who you are. But don’t be self-satisfied; that is not the same thing. ",
            "When one tugs at a single thing in nature, he finds it hitched to the rest of the universe. – John Muir",
            "Happiness is when what you think, what you say and what you do are in harmony. – Mahatma Gandhi",
            "An eye for an eye only ends up in making the whole world blind. – Mahatma Gandhi",
            "Try to make peace within yourself. Do not fight with yourself. – Shri Mataji Nirmala Devi",
            "He who asks a questions is a fool for five minutes. He who does not ask a question remains a fool forever.",
            "Begin your new life today! Treat people as if they were what they ought to be, and you’ll help them become what they are capable of being. ",
            "Nature does not hurry, yet everything is accomplished. – Lao Tzu",
            "It’s impossible, said pride; it’s risky, said experience; it’s pointless, said reason; give it a try, whispered the heart. ",
            "The joy of life comes from our encounters with new experiences, and hence there is no greater joy than to have an endlessly changing horizon, for each day to have a new and different sun. – Into the wild",
            "Think of good things of other people. If you have to enjoy the roses, you have to forget the thorns and enjoy roses. – Shri Mataji Nirmala Devi",
            "The best things can’t be told, because they transcend thought. The second best are often misunderstood, because those are the thoughts that are supposed to refer to that which can’t be thought about. The third best are what we talk about. – Heinrich Zimmer. ",
            "I bow to the seekers of truth. At the very outset we have to know that truth is what it is. We cannot think about it, we cannot conceptualise it. Unfortunately at this human level we cannot feel it, we cannot know it. We have to be the Spirit to know the truth. – Shri Mataji Nirmala Devi",
            "There is no need to condemn yourself in any way, or to elate yourself, but just be your Spirit. The best way to be with your Spirit is to forgive. – Shri Mataji Nirmala Devi",
            "The fun is created only through innocence and innocence is the only way you can really emit also the fun. Imagine this world without any fun, what would happen? – Shri Mataji Nirmala Devi",
            "When we love, we always strive to become better than we are. When we strive to become better than we are, everything around us becomes better too. – Paulo Caelho",
            "No matter what he does, every person on earth plays a central role in the history of the world. And normally he doesn’t know it. – Paulo Coelho",
            "The more I know about myself the more dynamic I become, the more expansive I become. – Shri Mataji Nirmala Devi",
            "If we do not know how to respect the Mother Earth, we do not know how to respect ourselves. – Shri Mataji Nirmala Devi",
            "When you know yourself you are surprised that what is the greatest thing for you is to love and to be loved. – Shri Mataji Nirmala Devi",
            "The evolution has to take place still within us to know ourselves. We can say that unless and until it is put to the mains, it has no meaning. Unless and until we are connected with the whole, we have no meaning. – Shri Mataji Nirmala Devi",
            "What do you have to surrender? A drop has to dissolve into the ocean to become the ocean. And a drop cannot be greater than the ocean, can it? So what is the surrendering? It is the surrendering of the conditionings, of our ego and the artificial barriers we have built around us. – Shri Mataji Nirmala Devi",
            "You should have only one intense desire within yourself: Have I become the spirit? Have I achieved my ultimate? Have I risen above the worldly desires? – Shri Mataji Nirmala Devi ",
            "Everyone has been made for some particular work, and the desire for that work has been out in every heart. – Rumi",
            "We are born of love; love is our mother. – Rumi",
            "You are not a drop in the ocean. You are the entire ocean in a drop. – Rumi",
            "Come, seek, for search is the foundation of fortune: every success depends upon focusing the heart. –Rumi",
            "Everything comes to us that belongs to us if we create the capacity to receive it. – R. Tagore",
            "I slept and dreamt that life was joy. I awoke and saw that life was service. I acted and behold, service was joy. – R. Tagore",
            "The most important lesson that man can learn from life, is not that there is pain in this world, but that it is possible for him to transmute it into joy. – R. Tagore",
            "When you are desiresless, you are happy, because you are never disappointed. – Shri Mataji Nirmala Devi",
            "Only in silence I find myself. Life in the city is so hectic that you lose the right perspective. It’s important to know that our biggest resources are in our heart. – R. Tagore",
            "And joy is everywhere; it is in the earth’s green covering of grass; in the blue serenity of the sky. – R. Tagore",
            "We cross infinity with every step; we meet eternity in every second. – R. Tagore",
            "It is in the very heart of our activity that we search for our goal. – R. Tagore",
            "We live in the world, when we love it. – R. Tagore",
            "The same stream of life that runs through the world runs through my veins night and day. – R. Tagore",
            "The world speaks to me in colours, my soul answers in music. – R. Tagore",
            "You are invited to the festival of this world and your life is blessed. – R. Tagore",
            "However great a man may be in society, without love he will lack the force a gravity, the sweet fragrance of a flower. – Shri Mataji Nirmala Devi",
            "People will forget what you said, people will forget what you did, but people will never forget how you made them feel. – Maya Angelou",
            "Oh Yes, the Past can hurt. But the way I see it, you can either run from it or learn from it. – The Lion King",
            "The problem is not the problem, the problem is your attitude about the problem ",
            "Speak in such a way that others love to listen to you. Listen in such a way that others love to speak to you. ",
            "How wonderful it is that nobody need wait a single moment before starting to improve the world. – Anne Frank",
            "Let us be grateful to people who make us happy, they are the charming gardeners who make our souls blossom. – Marcel Proust",
            "I would like to thank my arms for always being by my side. My legs for always supporting me and my fingers… because I can always count on them. ",
            "It’s about balance. Step with care and great tact and remember that life’s a great balancing act. – Dr. Suess",
            "Be who you are and ay what you feel, because those who mind don’t matter and those who matter don’t mind. – Dr. Suess",
            "We do not need magic to transform our world. We carry all the power we need inside ourselves already. – J.K Rowling",
            "You don’t always need a plan. Sometimes you just need to breath, trust, let go, and see what happens.",
            "Never forget what you are, for surely the world will not. Make it your strength. Then it can never be your weakness. – George R R Martin",
            "Everything becomes perfect as soon as you perfect yourself. ",
            "You cannot be lonely if you like the person you are alone with. ",
            "It’s your road and yours alone. Others may walk it with you but no one can walk it for you",
            "Eventually all the pieces fall into place. Until then, laugh at the confusion, live for the moment and know that everything happens for a reason.",
            "Try be the flower and not the thorn – Shri Mataji Nirmala Devi",
            "Love in your heart isn’t put there to stay. Love isn’t love until you give it away. – Roald Dahl",
            "The best way to treat obstacles is to use them as stepping stones… Laugh at them, tread on them, and let them lead you to something better. – Enid Blyton ",
            "An entire sea of water can’t sink a ship unless it gets inside. Similarly, the negativity of the world can’t put you down unless you allow it to get inside you.",
            "Life is like an ocean; sometimes calm and sometimes stormy but still it has beauty",
            "Life is like making tea. Boil your ego, evaporate your worries, dilute your sorrows, filter your mistakes and get a taste of happiness.",
            "It’s better to be the one who smiled than the one who didn’t smile back ",
            "RESPECT is a mirror. The more you show it to other people the more they will reflect it back. ",
            "Be the change that you wish to see in the world. – Mahatma Gandhi",
            "Be tolerant with others and accept all the differences. ",
            "Before you speak ask yourself if what you are going to say is true, is kind, is necessary, is helpful if the answer is no, maybe what you are about to say should be left unsaid. – Bernhard Meozer",
            "Live life like a par of walking legs. The foot forward has no pride. The foot behind has no shame because both know their situation will change. ",
            "It always seems impossible before it’s done. – Nelson Mandela ",
            "Love is the life-giving force of the family. It binds, nourishes and sustains the family. – Shri Mataji Nirmala Devi",
            "Coins always make sound but currency notes are always silent. So, when your value increases keep yourself calm and silent. – William Shakespear",
            "The journey of a thousand miles begins with one step. – Lao Tzu",
            "Nothing is impossible, the word itself says “I’m possible”! – Audrey Hepburn",
            "Do or do not. There is no try. — Yoda",
            "Strive not to be a success, but rather to be of value. — Albert Einstein",
            "It is during our darkest moments that we must focus to see the light. — Aristotle Onassis",
            "When you become thoughtlessly aware then you become completely peaceful within. – Shri Mataji Nirmala Devi",
            "A person who never made a mistake never tried anything new.— Albert Einstein",
            "I have been impressed with the urgency of doing. Knowing is not enough; we must apply. Being willing is not enough; we must do. — Leonardo da Vinci",
            "When I was 5 years old, my mother always told me that happiness was the key to life. When I went to school, they asked me what I wanted to be when I grew up. I wrote down “happy”. They told me I didn’t understand the assignment, and I told them they didn’t understand life. — John Lennon",
            "When we love, we always strive to become better than we are. When we strive to become better than we are, everything around us becomes better too. ― Paulo Coelho",
            "It is good to love many things, for therein lies the true strength, and whosoever loves much performs much, and can accomplish much, and what is done in love is well done. ― Vincent Van Gogh",
            "If you treat an individual as he is, he will remain how he is. But if you treat him as if he were what he ought to be and could be, he will become what he ought to be and could be. ― Johann Wolfgang von Goethe",
            "To give pleasure to a single heart by a single act is better than a thousand heads bowing in prayer.  ― Mahatma Gandhi",
            "The one who is not innocent is never wise. Wisdom comes only with innocence. – Shri Mataji Nirmala Devi",
            "Talk to everyone with an on open heart",
            "Modesty will let you grow inside and you will become beautiful – Shri Mataji Nirmala Devi ",
            "I never made one of my discoveries through the process of rational thinking ― Albert Einstein",
            "I learned that courage was not the absence of fear, but the triumph over it. The brave man is not he who does not feel afraid, but he who conquers that fear – Nelson Mandela",
            "Be patient with yourself and with others",
            "Live as if you were to die tomorrow. Learn as if you were to live forever. – Mahatma Gandhi",
            "A man is but a product of his thoughts. What he thinks he becomes. – Mahatma Gandhi",
            "Feel joy and let this joy spread through you",
            "How does a tree grow? By itself. Allow yourself to grow by yourself, through introspection and meditation. – Shri Mataji Nirmala Devi",
            "Money cannot replace reality, it’s just there.",
            "The weak can never forgive. Forgiveness is an attribute of the strong. – Mahatma Gandhi",
            "An ounce of patience is worth more than a tonne of preaching.",
            "Change yourself – you are in control. – Mahatma Gandhi",
            "If there is a disappointment, just smile at it and know it is for your good. – Shri Mataji Nirmala Devi",
            "Without action, you aren’t going anywhere. – Mahatma Gandhi",
            "Be congruent, be authentic, be your true self. – Mahatma Gandhi",
            "Continue to grow and evolve. – Mahatma Gandhi",
            "In a gentle way, you can shake the world. – Mahatma Gandhi",
            "Be very courageous, very bold and at the same time extremely humble. – Shri Mataji Nirmala Devi",
            "Injustice anywhere is a threat to justice everywhere. – Dr. Martin Luther King, Jr.",
            "When I do good, I feel good. When I do bad, I feel bad. That's my religion. – Abraham Lincoln",
            " The best thing about the future is that it comes one day at a time. – Abraham Lincoln",
            "Character is like a tree and reputation like a shadow. The shadow is what we think of it; the tree is the real thing. – Abraham Lincoln",
            "All that I am, or hope to be, I owe to my angel mother. – Abraham Lincoln",
            "You cannot escape the responsibility of tomorrow by evading it today. – Abraham Lincoln",
            "In the end, it’s not the years in your life that count. It’s the life in your years. – Abraham Lincoln",
            "Don’t worry when you are not recognized, but strive to be worthy of recognition. – Abraham Lincoln"
            ));





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // sets the balancing layout to the BaseActivityWithDrawer
        LayoutInflater.from(this).inflate(R.layout.activity_quote_day, getFrame());

//        Calendar thatDay = Calendar.getInstance();
//        thatDay.set(Calendar.DAY_OF_MONTH,3);
//        thatDay.set(Calendar.MONTH,1); // 0-11 so 1 less
//        thatDay.set(Calendar.YEAR, 2017);
//
//        Calendar today = Calendar.getInstance();
//
//
//        long diff = today.getTimeInMillis() - thatDay.getTimeInMillis();
//        int index = Math.abs(longToInt(diff));
//        index=index/(60*60*24*1000);

        Date date1 = new Date();
        Date date2 = new Date(2017,1,2);

        long diff = date1.getTime() - date2.getTime();
        long seconds = diff / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        int index = Math.abs(longToInt(days));

        TextView quoteD = (TextView)findViewById(R.id.textView1);
        quoteD.setText(quotes.get((index%137)));
        //quoteD.setText(Integer.toString(index));
        //quoteD.setText(Long.toString(today.getTimeInMillis()) + " " +Long.toString(thatDay.getTimeInMillis()));


    }

    public int longToInt(long theLongOne) {
        return Long.valueOf(theLongOne).intValue();
    }
}
