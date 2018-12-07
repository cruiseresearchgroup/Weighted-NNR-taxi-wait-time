> **If you use the resources (algorithm, code and dataset) presented in this repository, please cite our paper.**  
*The BibTeX entry is provided at the bottom of this page. 

# Wait Time Prediction for Airport Taxis using Weighted Nearest Neighbor Regression
In this paper, we address the neighborhood identification problem in the presence of a large number of heterogeneous contextual features. We formulate our research as a problem of queue wait time prediction for taxi drivers at airports and investigate heterogeneous factors related to time, weather, flight arrivals and taxi trips. The neighborhood-based methods have been applied to this type of problem previously. However, the failure to capture the relevant heterogeneous contextual factors and their weights during the calculation of neighborhoods can make existing methods ineffective. Specifically, a driver intelligence-biased weighting scheme is introduced to estimate the importance of each contextual factor which utilizes taxi drivers' intelligent moves. We argue that the quality of the identified neighborhood is significantly improved by considering the relevant heterogeneous contextual factors, thus boosting the prediction performance (i.e. mean prediction error < 0.09 and median prediction error < 0.06). To support our claim, we generated an airport taxi wait time dataset for the John F Kennedy (JFK) international airport by fusing three real-world contextual datasets including taxi trip logs, passenger wait times and weather conditions. Our experimental results demonstrate that the presence of heterogeneous contextual features and the drivers' intelligence-biased weighting scheme significantly outperform the baseline approaches for predicting taxi driver queue wait times.

This repository contains resources developed within the following paper:

  Rahaman, M. S., Ren, Y., Hamilton, M., Salim, F. D. (2018). Wait Time Prediction for Airport Taxis using Weighted Nearest Neighbor Regression
  In IEEE Access (pp. PP). IEEE.
  
You can find the [paper](link_to_your_github_pdf_resource_file.pdf) and [presentation](link_to_your_github_pdf_resource_file.pdf) in this repository. 

Alternative link: https://ieeexplore.ieee.org/document/8542712

## Contents of the repository
This repository contains resources used and described in the paper.

The repository is structured as follows:
> **NOTE:** this should follow the folders you have in this repository 

- `algorithms/`: Formal description of algorithm for entity normalization and sentence clustering.
- `data/`: Dataset used for this paper. 
- `code/`: Evaluation script.
- `evaluation/`: Evaluation script.
- `presentation/`: PDF of paper presentation in certain conference or venue.

## Code
Brief explanation about your code (where to start or how to run). 

## Data
Brief explanation of your datasets. 

## Possible Applications

## Additional Section
Additional section. 

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
