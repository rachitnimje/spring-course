import React, { useEffect, useState } from 'react';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import SearchIcon from '@mui/icons-material/Search';
import { Card, Grid, Typography, TextField, Box, InputAdornment } from "@mui/material";
import axios from "axios";
import { useNavigate } from 'react-router-dom';

const Search = () => {
  const [posts, setPosts] = useState([]);
  const [query, setQuery] = useState("");
  const navigate = useNavigate();

  const fetchPosts = async () => {
    try {
      let url = "http://localhost:8080/jobposts";
      if (query) {
        url = `http://localhost:8080/jobposts/keyword/${query}`;
      }
      const response = await axios.get(url);
      setPosts(response.data);
    } catch (error) {
      console.error("Error fetching posts:", error);
    }
  };

  useEffect(() => {
    fetchPosts();
  }, [query]);

  const handleEdit = (id) => {
    navigate("/edit", { state: { id } });
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/deletejobpost/${id}`);
      fetchPosts();
    } catch (error) {
      console.error("Error deleting post:", error);
    }
  };

  return (
    <Grid container spacing={2} sx={{ margin: "2%" }}>
      <Grid item xs={12} sx={12} md={12} lg={12}>
        <Box>
          <TextField
            InputProps={{
              startAdornment: (
                <InputAdornment position="start">
                  <SearchIcon />
                </InputAdornment>
              ),
            }}
            placeholder="Search..."
            sx={{ width: "75%", padding: "2% auto" }}
            fullWidth
            onChange={(e) => setQuery(e.target.value)}
          />
        </Box>
      </Grid>
      {posts?.map((p) => (
        <Grid key={p.postId} item xs={12} md={6} lg={4}>
          <Card sx={{ padding: "3%", overflow: "hidden", width: "84%", backgroundColor: "#ADD8E6" }}>
            <Typography variant="h5" sx={{ fontSize: "2rem", fontWeight: "600", fontFamily: "sans-serif" }}>
              {p.postProfile}
            </Typography>
            <Typography sx={{ color: "#585858", marginTop: "2%", fontFamily: "cursive" }} variant="body1">
              Description: {p.postDesc}
            </Typography>
            <br />
            <Typography variant="h6" sx={{ fontFamily: "unset", fontSize: "400" }}>
              Experience: {p.reqExperience} years
            </Typography>
            <Typography sx={{ fontFamily: "serif", fontSize: "400" }} gutterBottom variant="body1">
              Skills:
            </Typography>
            {p.postTechStack.map((s, i) => (
              <Typography variant="body1" gutterBottom key={i}>
                {s}{i < p.postTechStack.length - 1 ? ", " : ""}
              </Typography>
            ))}
            <DeleteIcon sx={{ cursor: "pointer", marginRight: "10px" }} onClick={() => handleDelete(p.postId)} />
            <EditIcon sx={{ cursor: "pointer" }} onClick={() => handleEdit(p.postId)} />
          </Card>
        </Grid>
      ))}
    </Grid>
  );
};

export default Search;