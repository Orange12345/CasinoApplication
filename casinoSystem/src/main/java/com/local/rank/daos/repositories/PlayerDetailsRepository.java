package com.local.rank.daos.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.local.rank.db.model.PlayerDetail;

@Repository
public interface PlayerDetailsRepository extends CrudRepository<PlayerDetail, Long>{

	/**
	 * Method  to find all PlayerDetail  for a playerid
	 * @param playerid of type long
	 *            is passed
	 * @return PlayerDetail is getting returned
	 */
	public PlayerDetail findByplayerid(long playerid);
	
	/**
	 * Method  to update the currentBalance PlayerDetail  for a playerid
	 * @param playerid of type long
	 *            is passed
	 * @return PlayerDetail is getting returned
	 */
	@Transactional
	@Modifying
	@Query(value="update PLAYER_DETAILS set currentbalance=?2 where playerid=?1",nativeQuery=true)
	public void updatePlayerid(long playerid,double currentBalance);
}
