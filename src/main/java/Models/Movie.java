/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author LENOVO
 */
import java.time.*;
public class Movie {
    private int movieId;
    private String movieName;
    private String movieDescription;
    private String movieTrailer;
    private int movieCens;
    private String movieGenres;
    private LocalDate movieRelease;
    private int movieLength;
    private String moviePoster;
    private Boolean isDeleted;

    // Constructors
    public Movie() {
    }

    public Movie(int movieId, String movieName, String movieDescription, String movieTrailer, int movieCens,
                 String movieGenres, LocalDate movieRelease, int movieLength, String moviePoster, Boolean isDeleted) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.movieTrailer = movieTrailer;
        this.movieCens = movieCens;
        this.movieGenres = movieGenres;
        this.movieRelease = movieRelease;
        this.movieLength = movieLength;
        this.moviePoster = moviePoster;
        this.isDeleted = isDeleted;
    }

    // Getters and Setters
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieTrailer() {
        return movieTrailer;
    }

    public void setMovieTrailer(String movieTrailer) {
        this.movieTrailer = movieTrailer;
    }

    public int getMovieCens() {
        return movieCens;
    }

    public void setMovieCens(int movieCens) {
        this.movieCens = movieCens;
    }

    public String getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(String movieGenres) {
        this.movieGenres = movieGenres;
    }

    public LocalDate getMovieRelease() {
        return movieRelease;
    }

    public void setMovieRelease(LocalDate movieRelease) {
        this.movieRelease = movieRelease;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
