> **If you use the resources (algorithm, code and dataset) presented in this repository, please cite our paper.**  
*The BibTeX entry is provided at the bottom of this page. 

# Wait Time Prediction for Airport Taxis using Weighted Nearest Neighbor Regression
In this paper, we address the neighborhood identification problem in the presence of a large number of heterogeneous contextual features. We formulate our research as a problem of queue wait time prediction for taxi drivers at airports and investigate heterogeneous factors related to time, weather, flight arrivals and taxi trips. The neighborhood-based methods have been applied to this type of problem previously. However, the failure to capture the relevant heterogeneous contextual factors and their weights during the calculation of neighborhoods can make existing methods ineffective. Specifically, a driver intelligence-biased weighting scheme is introduced to estimate the importance of each contextual factor which utilizes taxi drivers' intelligent moves. We argue that the quality of the identified neighborhood is significantly improved by considering the relevant heterogeneous contextual factors, thus boosting the prediction performance (i.e. mean prediction error < 0.09 and median prediction error < 0.06). To support our claim, we generated an airport taxi wait time dataset for the John F Kennedy (JFK) international airport by fusing three real-world contextual datasets including taxi trip logs, passenger wait times and weather conditions. Our experimental results demonstrate that the presence of heterogeneous contextual features and the drivers' intelligence-biased weighting scheme significantly outperform the baseline approaches for predicting taxi driver queue wait times.

This repository contains resources developed within the following paper:

  Rahaman, M. S., Ren, Y., Hamilton, M., Salim, F. D. (2018). Wait Time Prediction for Airport Taxis using Weighted Nearest Neighbor Regression
  In IEEE Access (pp. PP). IEEE.
  

Link to the paper: https://ieeexplore.ieee.org/document/8542712

## Contents of the repository
This repository contains resources used and described in the paper.

The repository is structured as follows:
> **NOTE:** this should follow the folders you have in this repository 

- `code/`: Evaluation script.
- `data/`: Dataset used for this paper. 

## Code
This code calculates the Feature weighted k-nearest neighbors. The feature weights are given as input to our code which is then used for distance calculation. To know more about the process of feature weight computation, please read our paper https://ieeexplore.ieee.org/document/8542712

## Data
To prepare our taxi wait time dataset for JFK airport, we integrate three publicly available datasets which include NYC taxi trip data from TLC, weather data from Weather underground and JFK passenger wait times data from U.S customs and border protection. 

## Possible Applications
The outcomes of this research have prospective application in airport ground transport management. The information of wait times in different places beyond airports can enable the taxi fleet managers in better planning and management of their fleet vehicles. 

## Citation
If you use the resources (code and dataset) presented in this repository, please cite (using the following BibTeX entry):
```
@ARTICLE{8542712, 
author={M. S. Rahaman and Y. Ren and M. Hamilton and F. D. Salim}, 
journal={IEEE Access}, 
title={Wait Time Prediction for Airport Taxis using Weighted Nearest Neighbor Regression}, 
year={2018}, 
volume={}, 
number={}, 
pages={1-1}, 
keywords={Public transportation;Airports;Atmospheric modeling;Meteorology;Queueing analysis;Feature extraction;Estimation;heterogeneous contextual features;neighborhood identification;wait time prediction;feature weighting}, 
doi={10.1109/ACCESS.2018.2882580}, 
ISSN={2169-3536}, 
month={},}
```
