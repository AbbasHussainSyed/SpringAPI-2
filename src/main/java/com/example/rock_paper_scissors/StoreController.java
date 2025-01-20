package com.example.rock_paper_scissors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*invokes spring REST API */
@RestController
@CrossOrigin
public class StoreController {

    static Score score = new Score(30, 20, 10);

    /*GET request Method using Spring Boot */
    @GetMapping("/health-check")
    public String getHealthCheck() {
        return "situation normal all fired up!";
    }

    //POST request method to increment the scores
    @PostMapping("/score/wins")
    public Score incrementScore() {
        score.wins++;
        return score;
    }

    //GET request method to retrieve scores
    @GetMapping("/score")
    public Score getScore() {
        return score;
    }

    //GET with @PathVARIABLE to increment scores based on url
    @GetMapping("/score/{winsorlossesorties}")
    public int getWinsLossesOrTies(@PathVariable String winsorlossesorties) {
        if (winsorlossesorties.equalsIgnoreCase("wins")) {
            return score.wins;
        }
        if (winsorlossesorties.equalsIgnoreCase("losses")) {
            return score.losses;
        }
        return score.ties;
    }


    //POST with @PathVARIABLE to increment scores based on url
    @PostMapping("/score/{postincrement}")
    public Score incWinsLosseOrTies(@PathVariable String postincrement) {
        if (postincrement.equalsIgnoreCase("wins")) {
            score.wins++;
        } else if (postincrement.equalsIgnoreCase("losses")) {
            score.losses++;
        } else {
            score.ties++;
        }
        return score;
    }

    //PUT: Replace an existing resource with an updated version, e.g. update all fields of a user record.
    @PutMapping("/score")
    public Score replaceScore(@RequestBody Score newScore) {
        score = newScore;
        return score;
    }

    //DELETE: Remove a resource from the server, e.g. delete a user record.
    @DeleteMapping("/score")
    public Score deleteScore() {
        score = null;
        return score;
    }

    // PATCH: Partially update an existing resource, e.g. update only certain fields of a user record.
    @PatchMapping("/score/wins")
    public Score updateWins(@RequestParam(name = "new-value") int newValue) {
        score.wins = newValue;
        return score;
    }

    @PatchMapping("/score/losses")
    public Score updateLosses(@RequestParam(name = "new-value") int newValue) {
        score.losses = newValue;
        return score;
    }

    @PatchMapping("/score/ties")
    public Score updateTies(@RequestParam(name = "new-value") int newValue) {
        score.ties = newValue;
        return score;
    }



    /*  
    //GET request method to retrieve wins 
    @GetMapping("/score/wins")
    public int getWins() {
        return score.wins;
    }
    
    //GET request method to retreive losses
    @GetMapping("/score/losses")
    public int getLosses() {
        return score.losses;
    }
    
    
    // GET request method to retreive ties
    @GetMapping("/score/ties")
    public int getTies() {
        return score.ties;
    }
    */
}