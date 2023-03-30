package dev.ayush.movies.service;

import dev.ayush.movies.models.Movies;
import dev.ayush.movies.models.Review;
import dev.ayush.movies.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    ReviewRepository reviewRepository;
    @Autowired
    ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }

    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody, String imdbId){

        Review review  = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movies.class).matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review)).first();

        return review;

    }
}
