import React from 'react';
import { usePagination, DOTS } from './usePagination';
import "./Pagination.css";

const Pagination = props => {
    const {
      onPageChange,
      totalCount,
      siblingCount = 1,
      currentPage,
      pageSize
    } = props;
  
    const paginationRange = usePagination({
      currentPage,
      totalCount,
      siblingCount,
      pageSize
    });
  
    if (currentPage === 0 || paginationRange.length < 2) {
      return null;
    }
  
    const onNext = () => {
      onPageChange(currentPage + 1);
    };
  
    const onPrevious = () => {
      onPageChange(currentPage - 1);
    };
  
    let lastPage = paginationRange[paginationRange.length - 1];
    return (

      <div className='d-flex justify-content-center'>

        <nav className='my-4 pt-2'>

          <ul
            className='pagination-container'
          >
            <li
              className={currentPage !== 1 ? "pagination-item" : "pagination-item disabled" }
              onClick={onPrevious}
            >
              <div className="arrow left" />
            </li>
            {paginationRange.map(pageNumber => {
              if (pageNumber === DOTS) {
                return <li className="pagination-item dots">&#8230;</li>;
              }
      
              return (
                <li
                  className='pagination-item'
                  onClick={() => onPageChange(pageNumber)}
                >
                  {pageNumber}
                </li>
              );
            })}
            <li
              className={currentPage !== lastPage ? "pagination-item" : "pagination-item disabled" }
              onClick={onNext}  
            >
              <div className="arrow right" />
            </li>
          </ul>

        </nav>


      </div>

    );
  };
  
  export default Pagination;