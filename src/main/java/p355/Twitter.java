package p355;

import java.util.*;
import java.util.stream.Collectors;

class Twitter {

  private Map<Integer, LinkedList<Post>> tweetMap;

  private Map<Integer, Set<Integer>> followerMap;

  /** Initialize your data structure here. */
  public Twitter() {
    tweetMap = new HashMap<>();
    followerMap = new HashMap<>();
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    if (tweetMap.containsKey(userId)) {
      LinkedList<Post> posts = tweetMap.get(userId);
      posts.addFirst(new Post(userId, tweetId));
    } else {
      LinkedList<Post> posts = new LinkedList<>();
      posts.addFirst(new Post(userId, tweetId));
      tweetMap.put(userId, posts);
    }
  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
   * be posted by users who the user followed or by the user herself. Tweets must be ordered from
   * most recent to least recent.
   */
  public List<Integer> getNewsFeed(int userId) {
    List<Post> allPost = new ArrayList<>();
    if (followerMap.containsKey(userId)) {
      Set<Integer> followers = followerMap.get(userId);
      for (int u : followers) {
        allPost.addAll(getTop10(u));
      }
      if (!followers.contains(userId)) {
        allPost.addAll(getTop10(userId));
      }
    } else {
      allPost.addAll(getTop10(userId));
    }
    return allPost.stream()
        .sorted((o1, o2) -> Long.compare(o2.postDate.getTime(), o1.postDate.getTime()))
        .limit(10)
        .map(Post::getTweetId)
        .collect(Collectors.toList());
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    if (followerMap.containsKey(followerId)) {
      Set<Integer> followers = followerMap.get(followerId);
      followers.add(followeeId);
    } else {
      Set<Integer> followers = new HashSet<>();
      followers.add(followeeId);
      followerMap.put(followerId, followers);
    }
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    if (followerMap.containsKey(followerId)) {
      Set<Integer> followers = followerMap.get(followerId);
      followers.remove(followeeId);
    }
  }

  private List<Post> getTop10(int userId) {
    if (tweetMap.containsKey(userId)) {
      List<Post> p = new ArrayList<>(10);
      LinkedList<Post> posts = tweetMap.get(userId);
      Iterator<Post> iter = posts.iterator();
      int i = 0;
      while (i < 10 && iter.hasNext()) {
        p.add(iter.next());
        i++;
      }

      return p;
    }
    return Collections.emptyList();
  }

  private static class Post {
    int userId;
    int tweetId;
    Date postDate;

    Post(int userId, int tweetId) {
      this.userId = userId;
      this.tweetId = tweetId;
      this.postDate = new Date();
    }

    public int getTweetId() {
      return tweetId;
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Twitter obj = new Twitter();
    obj.postTweet(1, 5);
    obj.follow(1, 1);
    System.out.println(obj.getNewsFeed(1));
  }
}
